# Fragments

Fragments são como partes reutilizaveis de uma activity, é possivel criar uma activity com varias estancias de
fragments assim tera uma activity dinâmica.

O principal vantagem dos fragments, são para reaproveitamento de codigo e UI.

Existem dois tipos de fragments, os (STATICOS e DINÂMICOS)

## fragments staticos
fragments staticos muitas muitas vezes, seu layout já definido no proprio XML da activity.
Exemplo: Em um tablet, nas configurações, a lista de menu que fica a esquerda, será um fragment statico, onde
por mais que os itens de menu aumente, aquele fragment serem exibirar aquila lista.

## fragments dinâmicos
fragments dinâmicos geralmente seu layout é trocado em tempo de execução.
Exemplo: voltando ao exemplo acima, no toque de cada item do menu configurção, neste será apresentado um layout diferente
de cada menu.

Como as activitys, os fragments tambem tem seu ciclo de vida.