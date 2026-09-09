from personagem import Personagem

class Guerreiro(Personagem):
    def __init__(self, nome, vida, nivel):
        super().__init__(nome, vida, nivel)
        self.defesa = 5

    def get_defesa(self):
        return self.defesa

    def set_defesa(self, defesa):
        if defesa >= 0:
            self.defesa = defesa
        else:
            print("Defesa inválida")

    def receber_dano(self, dano):
        super().receber_dano(max(0, dano - self.defesa))

    def ficha(self):
        return super().ficha() + f"\nDefesa: {self.defesa}"

    def habilidade(self):
        return "escudo de aço"