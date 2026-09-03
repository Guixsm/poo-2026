
 # Uso de IA:
 # Ferramenta utilizada: ChatGPT.
 # Finalidade: esclarecer minhas dúvidas sobre os conceitos de herança,
 # composição e sobrescrita de métodos, além de auxiliar na revisão
 # do código que desenvolvi.
 # Desenvolvi e implementei o código manualmente. Utilizei a IA como
 # apoio para tirar dúvidas e revisar minha implementação. Realizei
 # os testes e as validações manualmente.

from Item import Item
from Mago import Mago
from Guerreiro import Guerreiro

espada = Item("Espada de Aço", 3)
print(espada.descricao())

frieren = Mago("Frieren", 100, 5)
frieren.pegar(espada)
print(frieren.ficha())
print()
frieren.mana = -10
print("Mana após tentativa:", frieren.mana)
print()
darkin = Guerreiro("Darkin", 100, 10)
print(darkin.ficha())
print()

darkin.receber_dano(8)
print("Vida após tomar 8 de dano:", darkin.vida)