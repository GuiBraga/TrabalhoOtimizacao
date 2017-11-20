<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

<div style="padding: 10px;">
      <h1 align="center">Trabalho de Otimiza&ccedil&atildeo</h1>
    </div>

    <div align="center">
      Esta aplica&ccedil&atildeo visa resolver o problema de Mix de Produ&ccedil&atildeo atrav&eacutes da utiliza&ccedil&atildeo
      do m&eacutetodo simplex e da biblioteca do GLPK
    </div>

    <div align="center" class="resultado">
      <h3>Resultado</h3>

      <div align = "left">
        <label>Z = </label>
        <span>
          <c:out value="${simplex.resolucao.z}"></c:out>
        </span>
        <br>

        <label>X1 = </label>
        <span>
          <c:out value="${simplex.resolucao.x1}"></c:out>
        </span>
        <br>

        <label>X2 = </label>
        <span>
          <c:out value="${simplex.resolucao.x2}"></c:out>
        </span>
        <br>
      </div>
   </div>
   <div align="center">
  	<a href="/" class="btn btn-primary gerarNovo">Gerar Novo</a>
  </div>
  </div>
  
<jsp:include page="footer.jsp"></jsp:include>