<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="header.jsp"></jsp:include>

<div>
<h1 align="center">Trabalho de Otimiza&ccedil&atildeo</h1>
</div>
<div>
blablablablablablabla <br /><br />
</div>
<form action="/calcular" method="post">
<div> 
<h3>Qual &eacute o objetivo?</h3>
<div class="radio">
  <label><input type="radio" name="optradio">Maximixar</label>
</div>
<div class="radio">
  <label><input type="radio" name="optradio">Minimizar</label>
</div>
<br /><br />
</div>
<div>
<table class="table table-hover table-responsive table-bordered">
  <tr>
    <td width="15%"><b>Fun&ccedil&atildeo</b></td>
    <td width="85%"><input type="number" name="valorx" class="form-control" min="1" max="999" size="4" required/> x + <input type="number" name="valory" class="form-control" min="1" max="999" required/> y = 0</td>
  </tr>
  <tr>
    <td><b>Resticao 1</b></td>
    <td><input type="number" name="rest1x" class="form-control" min="1" max="999" required/> x + <input type="number" name="rest1y" class="form-control" min="1" max="999" required/> y <select name="rest1ope"><option value="menor">menor igual</option><option value="maior">maior igual</option><option value="igual">igual</option></select> <input type="number" name="totalrest1" class="form-control" min="1" max="999" required/></td>
  </tr>
  <tr>
    <td><b>Resticao 2</b></td>
    <td><input type="number" name="rest2x" class="form-control" min="1" max="999" required/> x + <input type="number" name="rest2y" class="form-control" min="1" max="999" required/> y <select name="rest2ope"><option value="menor">menor igual</option><option value="maior">maior igual</option><option value="igual">igual</option></select>  <input type="number" name="totalrest2" class="form-control" min="1" max="999" required/></td>
  </tr>
   <tr>
    <td><b>Resticao 3</b></td>
    <td><input type="number" name="rest3x" class="form-control" min="1" max="999" required/> x + <input type="number" name="rest3y" class="form-control" min="1" max="999" required/> y <select name="rest3ope"><option value="menor">menor igual</option><option value="maior">maior igual</option><option value="igual">igual</option></select>  <input type="number" name="totalrest3" class="form-control" min="1" max="999" required/></td>
  </tr>
</table>
<div align="center">
<br /><br />
<button type="submit" class="btn btn-primary">Calcular</button>
</div>
</div>
</form>
<jsp:include page="footer.jsp"></jsp:include>