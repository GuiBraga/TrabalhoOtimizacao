<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>


    <div style="padding: 10px;">
      <h1 align="center">Trabalho de Otimiza&ccedil&atildeo</h1>
    </div>

    <div align="center">
      Escreva algo bonitinho
    </div>

    <div>
      <form action="/calcular" method="post">

        <div align="center">
          <h3>Qual &eacute o objetivo?</h3>
          <select id="objetivo" name="objetivo">
            <option value="">Selecione uma Op&ccedil&atildeo</option>
            <option value="1">Minimizar</option>
            <option value="2">Maximizar</option>
          </select>
        </div>
        <br>
        <br>

        <div align="center">
          <h5>
            <b>Fun&ccedil&atildeo Objetiva</b>
          </h5>
          <label>X =</label>
          <input type="number" name="valorx" class="form-control" required/>
          <label>Y =</label>
          <input type="number" name="valory" class="form-control" required/>
        </div>
        <br>

        <div align="center">
          <h5>
            <b>Restri&ccedil&otildees</b>
          </h5>
          <label>X =</label>
          <input type="number" name="rest1x" class="form-control" required/>
          <label>Y =</label>
          <input type="number" name="rest1y" class="form-control" required/>

          <select name="rest1ope">
            <option value="">Selecione</option>
            <option value="menor">menor igual</option>
            <option value="maior">maior igual</option>
            <option value="igual">igual</option>
          </select>

          <input type="number" name="totalrest1" class="form-control" required/>
        </div>

        <div align="center">
          <label>X =</label>
          <input type="number" name="rest2x" class="form-control" required/>
          <label>Y =</label>
          <input type="number" name="rest2y" class="form-control" required/>

          <select name="rest2ope">
            <option value="">Selecione</option>
            <option value="menor">menor igual</option>
            <option value="maior">maior igual</option>
            <option value="igual">igual</option>
          </select>

          <input type="number" name="totalrest2" class="form-control" required/>
        </div>


        <div align="center">
          <label>X =</label>
          <input type="number" name="rest3x" class="form-control" required/>
          <label>Y =</label>
          <input type="number" name="rest3y" class="form-control" required/>

          <select name="rest3ope">
            <option value="">Selecione</option>
            <option value="menor">menor igual</option>
            <option value="maior">maior igual</option>
            <option value="igual">igual</option>
          </select>

          <input type="number" name="totalrest3" class="form-control" required/>
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