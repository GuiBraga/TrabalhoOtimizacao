<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

    <div style="padding: 10px;">
      <h1 align="center">Trabalho de Otimiza&ccedil&atildeo</h1>
    </div>

    <div align="center">
      Esta aplica&ccedil&atildeo visa resolver o problema de Mix de Produ&ccedil&atildeo atrav&eacutes da utiliza&ccedil&atildeo do m&eacutetodo simplex e da biblioteca do GLPK
    </div>

    <div>
      <b>Z = <c:out value="${simplex.resolucao.z}"></c:out></b>
      <b>X1 = <c:out value="${simplex.resolucao.x1}"></c:out></b>
      <b>X2 = <c:out value="${simplex.resolucao.x2}"></c:out></b>
  </div>
  </div>
<jsp:include page="footer.jsp"></jsp:include>