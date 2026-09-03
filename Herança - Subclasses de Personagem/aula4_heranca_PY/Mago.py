from Personagem import Personagem

class Mago(Personagem):
    def __init__(self, nome, vida, nivel):
        super().__init__()
        self.nome = nome
        self.vida = vida
        self.nivel = nivel
        self._mana = 50

    @property
    def mana(self):
        return self._mana

    @mana.setter
    def mana(self, valor):
        if valor < 0:
            print("Mana inválida")
        else:
            self._mana = valor

    def ficha(self):
        return super().ficha() + "\nMana: " + str(self._mana)