<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>


    <div style="padding: 10px;">
      <h1 align="center">Trabalho de Otimiza&ccedil&atildeo</h1>
    </div>

    <div align="center">
      Esta aplica&ccedil&atildeo visa resolver o problema de Mix de Produ&ccedil&atildeo atrav&eacutes utilizando a biblioteca do GLPK
    </div>

    <div>
      <form action="/calcular" method="post">

        <div align="center" class="objetivo">
          <h3>Qual &eacute o objetivo?</h3>
          <select name="funcaoObjetiva.objetivo" required>
            <option value="">Selecione uma Op&ccedil&atildeo</option>
            <option value="Minimizar">Minimizar</option>
            <option value="Maximizar">Maximizar</option>
          </select>
        </div>
        <br>
        <br>

	<div class="variaveis">
        <div align="left">
          <h5>
            <b>Fun&ccedil&atildeo Objetiva</b>
          </h5>
          <label>F.O &#10132; &nbsp;&nbsp; Z =	</label>
          <input type="number" name="funcaoObjetiva.x1" class="form-control" placeholder="X1" step="0.01" required />
          <label> + </label>
          <input type="number" name="funcaoObjetiva.x2" class="form-control" placeholder="X2" step="0.01" required/>
        </div>
        <br>

        <div align="left">
          <h5>
            <b>Restri&ccedil&otildees</b>
          </h5>
          <label>1. &nbsp;&nbsp;</label>
          <input type="number" name="restricao1.x1" class="form-control" placeholder="X1" step="0.01" required/>
          <label> + </label>
          <input type="number" name="restricao1.x2" class="form-control" placeholder="X2" step="0.01" required/>

          <select name="restricao1.operador" required>
            <option value="">Selecione</option>
            <option value="menor"> <= </option>
            <option value="maior"> >= </option>
            <option value="igual"> = </option>
          </select>

          <input type="number" name="restricao1.total" class="form-control" placeholder="Disp." step="0.01" required/>
        </div>

        <div align="left">
          <label>2. &nbsp;&nbsp;</label>
          <input type="number" name="restricao2.x1" class="form-control" placeholder="X1" step="0.01" required/>
          <label> + </label>
          <input type="number" name="restricao2.x2" class="form-control" placeholder="X2" step="0.01" required/>

          <select name="restricao2.operador" required>
            <option value="">Selecione</option>
            <option value="menor"> <= </option>
            <option value="maior"> >= </option>
            <option value="igual"> = </option>
          </select>

          <input type="number" name="restricao2.total" class="form-control" placeholder="Disp." step="0.01" required/>
        </div>


        <div align="left">
          <label>3. &nbsp;&nbsp;</label>
          <input type="number" name="restricao3.x1" class="form-control" placeholder="X1" step="0.01" required/>
          <label> + </label>
          <input type="number" name="restricao3.x2" class="form-control" placeholder="X2" step="0.01" required/>

          <select name="restricao3.operador" required>
            <option value="">Selecione</option>
            <option value="menor"> <= </option>
            <option value="maior"> >= </option>
            <option value="igual"> = </option>
          </select>

          <input type="number" name="restricao3.total" class="form-control" placeholder="Disp." step="0.01" required/>
        </div>

        <div align="left">
          <br>
          <button type="submit" class="btn btn-primary">Calcular</button>
        </div>
       <div>
    </div>
    </form>
  </div>
  </div>
<jsp:include page="footer.jsp"></jsp:include>