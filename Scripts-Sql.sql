select id_loja_virtual_pa, categoria_loja.id_natureza_produto_ra , count(*) as qtde, date(preco_produto.data_ultima_visita) as data_ultima_visita
from preco_produto 
inner join produto on produto.id_produto = preco_produto.id_produto_pa 
inner join categoria_loja_produto on categoria_loja_produto.id_produto_ra = preco_produto.id_produto_pa  
inner join categoria_loja on categoria_loja.id_categoria_loja = categoria_loja_produto.id_categoria_loja_ra
where date(preco_produto.data_ultima_visita) = curdate() 
group by id_loja_virtual_pa, categoria_loja.id_natureza_produto_ra,  date(preco_produto.data_ultima_visita) 
