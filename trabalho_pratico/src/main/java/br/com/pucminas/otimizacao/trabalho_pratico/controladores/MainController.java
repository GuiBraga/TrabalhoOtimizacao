package br.com.pucminas.otimizacao.trabalho_pratico.controladores;

import org.gnu.glpk.GLPK;
import org.gnu.glpk.GLPKConstants;
import org.gnu.glpk.GlpkException;
import org.gnu.glpk.SWIGTYPE_p_double;
import org.gnu.glpk.SWIGTYPE_p_int;
import org.gnu.glpk.glp_prob;
import org.gnu.glpk.glp_smcp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.pucminas.otimizacao.trabalho_pratico.modelos.Problema;
import br.com.pucminas.otimizacao.trabalho_pratico.modelos.Resolucao;
import br.com.pucminas.otimizacao.trabalho_pratico.modelos.Simplex;

@Controller
public class MainController {

	@RequestMapping(value = "/calcular", method = RequestMethod.POST)
	public String calculaProblema(@ModelAttribute("problema") Problema problema, ModelMap modelMap) {
		System.out.println(problema.toString());
		Simplex simplex = resolverProblema(problema);
		System.out.println(simplex.toString());
		
		modelMap.addAttribute("simplex", simplex);
        return "resposta";
        
//		ModelAndView model = new ModelAndView("resposta");
//        model.addObject("hello", "hello");
//        return "resposta";
	}

	private Simplex resolverProblema(Problema problema) {
		Resolucao resolucao = new Resolucao();
		glp_prob lp;
		glp_smcp parm;
		SWIGTYPE_p_int ind;
		SWIGTYPE_p_double val;
		int ret;
		try {
			// Create problem
			lp = GLPK.glp_create_prob();
			GLPK.glp_set_prob_name(lp, "myProblem");
			// Define columns
			GLPK.glp_add_cols(lp, 2);
			GLPK.glp_set_col_name(lp, 1, "x1");
			GLPK.glp_set_col_kind(lp, 1, GLPKConstants.GLP_CV);
			GLPK.glp_set_col_bnds(lp, 1, GLPKConstants.GLP_DB, 0, 0);
			GLPK.glp_set_col_name(lp, 2, "x2");
			GLPK.glp_set_col_kind(lp, 2, GLPKConstants.GLP_CV);
			GLPK.glp_set_col_bnds(lp, 2, GLPKConstants.GLP_DB, 0, 0);

			// Create constraints
			GLPK.glp_add_rows(lp, 3);
			GLPK.glp_set_row_name(lp, 1, "c1");
			GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_DB, 0, problema.getRestricao1().getTotal());
			ind = GLPK.new_intArray(3);
			GLPK.intArray_setitem(ind, 1, 1);
			GLPK.intArray_setitem(ind, 2, 2);
			val = GLPK.new_doubleArray(3);
			GLPK.doubleArray_setitem(val, 1, problema.getRestricao1().getX1());
			GLPK.doubleArray_setitem(val, 2, problema.getRestricao1().getX2());
			GLPK.glp_set_mat_row(lp, 1, 2, ind, val);

			GLPK.glp_set_row_name(lp, 1, "c2");
			GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_DB, 0, problema.getRestricao2().getTotal());
			ind = GLPK.new_intArray(3);
			GLPK.intArray_setitem(ind, 1, 1);
			GLPK.intArray_setitem(ind, 2, 2);
			val = GLPK.new_doubleArray(3);
			GLPK.doubleArray_setitem(val, 1, problema.getRestricao2().getX1());
			GLPK.doubleArray_setitem(val, 2, problema.getRestricao2().getX2());
			GLPK.glp_set_mat_row(lp, 1, 2, ind, val);

			GLPK.glp_set_row_name(lp, 1, "c3");
			GLPK.glp_set_row_bnds(lp, 1, GLPKConstants.GLP_DB, 0, problema.getRestricao3().getTotal());
			ind = GLPK.new_intArray(3);
			GLPK.intArray_setitem(ind, 1, 1);
			GLPK.intArray_setitem(ind, 2, 2);
			val = GLPK.new_doubleArray(3);
			GLPK.doubleArray_setitem(val, 1, problema.getRestricao3().getX1());
			GLPK.doubleArray_setitem(val, 2, problema.getRestricao3().getX2());
			GLPK.glp_set_mat_row(lp, 1, 2, ind, val);

			// Define objective
			GLPK.glp_set_obj_name(lp, "z");
			if (problema.getFuncaoObjetiva().getObjetivo().equals("Maximizar")) {
				GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MAX);
			} else {
				GLPK.glp_set_obj_dir(lp, GLPKConstants.GLP_MIN);
			}
			GLPK.glp_set_obj_coef(lp, 0, 0);
			GLPK.glp_set_obj_coef(lp, 1, problema.getFuncaoObjetiva().getX1());
			GLPK.glp_set_obj_coef(lp, 2, problema.getFuncaoObjetiva().getX2());
			// Solve model
			parm = new glp_smcp();
			GLPK.glp_init_smcp(parm);
			ret = GLPK.glp_simplex(lp, parm);
			// Retrieve solution
			if (ret == 0) {
				System.out.print(GLPK.glp_get_obj_name(lp));
				System.out.print(" = ");
				System.out.println(GLPK.glp_get_obj_val(lp));
				if (GLPK.glp_get_obj_name(lp).equals("z")) {
					resolucao.setZ(GLPK.glp_get_obj_val(lp));
				}
				for (int i = 1; i <= GLPK.glp_get_num_cols(lp); i++) {
					System.out.print(GLPK.glp_get_col_name(lp, i));
					System.out.print(" = ");
					System.out.println(GLPK.glp_get_col_prim(lp, i));
					switch (GLPK.glp_get_col_name(lp, i)) {
					case "x1":
						resolucao.setX1(GLPK.glp_get_col_prim(lp, i));
						break;
					case "x2":
						resolucao.setX1(GLPK.glp_get_col_prim(lp, i));
						break;
					default:
						break;
					}
				}
			} else {
				System.out.println("The problem could not be solved");
			}
			// Free memory
			GLPK.glp_delete_prob(lp);

			return new Simplex(problema, resolucao);
		} catch (GlpkException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/")
	public String index() {
		return "index";
	}
}
