package br.com.pucminas.otimizacao.trabalho_pratico.controladores;

import java.text.DecimalFormat;

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

		System.loadLibrary("glpk_4_63");
		System.loadLibrary("glpk_4_63_java");

		Simplex simplex = resolverProblema(problema);

		modelMap.addAttribute("simplex", simplex);
		return "resposta";
	}

	private Simplex resolverProblema(Problema problema) {
		Resolucao resolucao = new Resolucao();
		glp_prob problemaGLPK;
		glp_smcp parm;
		SWIGTYPE_p_int ind;
		SWIGTYPE_p_double val;
		int ret;
		try {
			// Create problem
			problemaGLPK = GLPK.glp_create_prob();
			GLPK.glp_set_prob_name(problemaGLPK, "Problema - Mix de Producao");
			// Define columns
			GLPK.glp_add_cols(problemaGLPK, 2);
			GLPK.glp_set_col_name(problemaGLPK, 1, "x1");
			GLPK.glp_set_col_kind(problemaGLPK, 1, GLPKConstants.GLP_CV);
			GLPK.glp_set_col_bnds(problemaGLPK, 1, GLPKConstants.GLP_LO, 0, 0);
			GLPK.glp_set_col_name(problemaGLPK, 2, "x2");
			GLPK.glp_set_col_kind(problemaGLPK, 2, GLPKConstants.GLP_CV);
			GLPK.glp_set_col_bnds(problemaGLPK, 2, GLPKConstants.GLP_LO, 0, 0);

			
            // Allocate memory
            ind = GLPK.new_intArray(3);
            val = GLPK.new_doubleArray(3);
			
			// Create constraints
			GLPK.glp_add_rows(problemaGLPK, 3);
			
			
			GLPK.glp_set_row_name(problemaGLPK, 1, "c1");
			switch (problema.getRestricao1().getOperador()) {
			case "menor":
				GLPK.glp_set_row_bnds(problemaGLPK, 1, GLPKConstants.GLP_UP, 0, problema.getRestricao1().getTotal());
				break;
			case "maior":
				GLPK.glp_set_row_bnds(problemaGLPK, 1, GLPKConstants.GLP_LO, problema.getRestricao1().getTotal(), 0);
				break;			
			default:
				break;
			}
			//ind = GLPK.new_intArray(3);
			GLPK.intArray_setitem(ind, 1, 1);
			GLPK.intArray_setitem(ind, 2, 2);
			//val = GLPK.new_doubleArray(3);
			GLPK.doubleArray_setitem(val, 1, problema.getRestricao1().getX1());
			GLPK.doubleArray_setitem(val, 2, problema.getRestricao1().getX2());
			GLPK.glp_set_mat_row(problemaGLPK, 1, 2, ind, val);

			GLPK.glp_set_row_name(problemaGLPK, 2, "c2");
			switch (problema.getRestricao2().getOperador()) {
			case "menor":
				GLPK.glp_set_row_bnds(problemaGLPK, 2, GLPKConstants.GLP_UP, 0, problema.getRestricao2().getTotal());
				break;
			case "maior":
				GLPK.glp_set_row_bnds(problemaGLPK, 2, GLPKConstants.GLP_LO, problema.getRestricao2().getTotal(), 0);
				break;
			default:
				break;
			}
			//ind = GLPK.new_intArray(3);
			GLPK.intArray_setitem(ind, 1, 1);
			GLPK.intArray_setitem(ind, 2, 2);
			//val = GLPK.new_doubleArray(3);
			GLPK.doubleArray_setitem(val, 1, problema.getRestricao2().getX1());
			GLPK.doubleArray_setitem(val, 2, problema.getRestricao2().getX2());
			GLPK.glp_set_mat_row(problemaGLPK, 2, 2, ind, val);

			GLPK.glp_set_row_name(problemaGLPK, 3, "c3");
			switch (problema.getRestricao3().getOperador()) {
			case "menor":
				GLPK.glp_set_row_bnds(problemaGLPK, 3, GLPKConstants.GLP_UP, 0, problema.getRestricao3().getTotal());
				break;
			case "maior":
				GLPK.glp_set_row_bnds(problemaGLPK, 3, GLPKConstants.GLP_LO, problema.getRestricao3().getTotal(), 0);
				break;			
			default:
				break;
			}
			//ind = GLPK.new_intArray(3);
			GLPK.intArray_setitem(ind, 1, 1);
			GLPK.intArray_setitem(ind, 2, 2);
			//val = GLPK.new_doubleArray(3);
			GLPK.doubleArray_setitem(val, 1, problema.getRestricao3().getX1());
			GLPK.doubleArray_setitem(val, 2, problema.getRestricao3().getX2());
			GLPK.glp_set_mat_row(problemaGLPK, 3, 2, ind, val);
			
			// Free memory
    		GLPK.delete_intArray(ind);
			GLPK.delete_doubleArray(val);
						
			// Define objective
			GLPK.glp_set_obj_name(problemaGLPK, "z");
			if (problema.getFuncaoObjetiva().getObjetivo().toLowerCase().equals("maximizar")) {
				GLPK.glp_set_obj_dir(problemaGLPK, GLPKConstants.GLP_MAX);
			} 
			if (problema.getFuncaoObjetiva().getObjetivo().toLowerCase().equals("minimizar")) {
				GLPK.glp_set_obj_dir(problemaGLPK, GLPKConstants.GLP_MIN);
			}
			GLPK.glp_set_obj_coef(problemaGLPK, 0, 0);
			GLPK.glp_set_obj_coef(problemaGLPK, 1, problema.getFuncaoObjetiva().getX1());
			GLPK.glp_set_obj_coef(problemaGLPK, 2, problema.getFuncaoObjetiva().getX2());
			
			
			// Solve model
			parm = new glp_smcp();
			GLPK.glp_init_smcp(parm);
			ret = GLPK.glp_simplex(problemaGLPK, parm);
			GLPK.glp_term_out(1);
			
			// Retrieve solution
			if (ret == 0) {
				System.out.print(GLPK.glp_get_obj_name(problemaGLPK));
				System.out.print(" = ");
				System.out.println(GLPK.glp_get_obj_val(problemaGLPK));
				if (GLPK.glp_get_obj_name(problemaGLPK).equals("z")) {
					double valor = GLPK.glp_get_obj_val(problemaGLPK);
					DecimalFormat formato = new DecimalFormat("#.##");      
					valor = Double.valueOf(formato.format(valor).replace(",", "."));
					resolucao.setZ(valor);
				}
				for (int i = 1; i <= GLPK.glp_get_num_cols(problemaGLPK); i++) {
					System.out.print(GLPK.glp_get_col_name(problemaGLPK, i));
					System.out.print(" = ");
					System.out.println(GLPK.glp_get_col_prim(problemaGLPK, i));
					double valor = GLPK.glp_get_col_prim(problemaGLPK, i);
					DecimalFormat formato = new DecimalFormat("#.##");      
					valor = Double.valueOf(formato.format(valor).replace(",", "."));
					switch (GLPK.glp_get_col_name(problemaGLPK, i)) {
					case "x1":
						resolucao.setX1(valor);
						break;
					case "x2":
						resolucao.setX2(valor);
						break;
					default:
						break;
					}
				}
			} else {
				System.out.println("The problem could not be solved");
			}
			// Free memory
			GLPK.glp_delete_prob(problemaGLPK);

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
