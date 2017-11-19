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

        <div align="center">
          <h3>Qual &eacute o objetivo?</h3>
          <select name="funcaoObjetiva.objetivo">
            <option value="">Selecione uma Op&ccedil&atildeo</option>
            <option value="Minimizar">Minimizar</option>
            <option value="Maximizar">Maximizar</option>
          </select>
        </div>
        <br>
        <br>

        <div align="center">
          <h5>
            <b>Fun&ccedil&atildeo Objetiva</b>
          </h5>
          <label>X1 =</label>
          <input type="number" name="funcaoObjetiva.x1" class="form-control" required/>
          <label>X2 =</label>
          <input type="number" name="funcaoObjetiva.x2" class="form-control" required/>
        </div>
        <br>

        <div align="center">
          <h5>
            <b>Restri&ccedil&otildees</b>
          </h5>
          <label>X1 =</label>
          <input type="number" name="restricao1.x1" class="form-control" required/>
          <label>X2 =</label>
          <input type="number" name="restricao1.x2" class="form-control" required/>

          <select name="restricao1.operador">
            <option value="">Selecione</option>
            <option value="menor">menor igual</option>
            <option value="maior">maior igual</option>
            <option value="igual">igual</option>
          </select>

          <input type="number" name="restricao1.total" class="form-control" required/>
        </div>

        <div align="center">
          <label>X1 =</label>
          <input type="number" name="restricao2.x1" class="form-control" required/>
          <label>X2 =</label>
          <input type="number" name="restricao2.x2" class="form-control" required/>

          <select name="restricao2.operador">
            <option value="">Selecione</option>
            <option value="menor">menor igual</option>
            <option value="maior">maior igual</option>
            <option value="igual">igual</option>
          </select>

          <input type="number" name="restricao2.total" class="form-control" required/>
        </div>


        <div align="center">
          <label>X1 =</label>
          <input type="number" name="restricao3.x1" class="form-control" required/>
          <label>X2 =</label>
          <input type="number" name="restricao3.x2" class="form-control" required/>

          <select name="restricao3.operador">
            <option value="">Selecione</option>
            <option value="menor">menor igual</option>
            <option value="maior">maior igual</option>
            <option value="igual">igual</option>
          </select>

          <input type="number" name="restricao3.total" class="form-control" required/>
        </div>

        <div align="center">
          <br />
          <br />
          <button type="submit" class="btn btn-primary">Calcular</button>
        </div>
    </div>
    </form>
  </div>
  </div>
<jsp:include page="footer.jsp"></jsp:include>