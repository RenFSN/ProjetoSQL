SELECT Agencias.idAgencia,
Agencias.Telefone,
Funcionarios.Cidade,
Agencias.Endereco,
Funcionarios.idCargo as gerente
from Funcionarios inner join Agencias
on Funcionarios.idFuncionario = Funcionarios.idFuncionario

SELECT nome,
Funcionarios.Cidade,
Agencias.Endereco,
Funcionarios.DDD,
Agencias.TElefone,
Funcionarios.idcargo
From Funcionarios inner join Agencias
on funcionarios.idfuncionario = funcionarios.idfuncionario

SELECT tipoCartao.idTipoCartao,
tipoCartao.Anuidade,
tipoCartao.rendaMinima
FROM Cliente_Cartao inner join tipoCartao
on tipoCartao.idTipoCartao = tipoCartao.idTipoCartao