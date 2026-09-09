from personagem import Personagem

class Mago(Personagem):
    def __init__(self, nome, vida, nivel):
        super().__init__(nome, vida, nivel)
        self.mana = 50

    def get_mana(self):
        return self.mana

    def set_mana(self, mana):
        if mana >= 0:
            self.mana = mana
        else:
            print("Mana menor que 0, é inválida!")

    def ficha(self):
        return super().ficha() + f"\nMana: {self.mana}"

    def habilidade(self):
        return "rajada arcana"