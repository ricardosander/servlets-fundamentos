<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>
<c:if test="${usuarioLogado != null}">
	Você está logado como ${usuarioLogado.email}<br/>
</c:if>


<form action="novaEmpresa" method="post">
    Nome: <input type="text" name="nome" /><br />
    <input type="submit" value="Enviar" />
</form>

<form action="login" method="post">
    Nome: <input type="text" name="email" /><br />
    Senha: <input type="password" name="senha" /><br/>
    <input type="submit" value="Enviar" />
</form>

<form action="logout" method="post">
    <input type="submit" value="Logout" />
</form>
</body>
</html>