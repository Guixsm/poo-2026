from personagem import Personagem

class Chefe(Personagem):
    def __init__(self, nome):
        # vida fixa em 200, nível arbitrário (não especificado no
        # enunciado, usei 10 por ser um chefe de fim de jogo)
        super().__init__(nome, 200, 10)
        self.forca = 20

    def get_forca(self):
        return self.forca

    def habilidade(self):
        return "ataque devastador"

    def ficha(self):
        # Reaproveita a ficha herdada e acrescenta o indicador visual
        # [CHEFE] mais o atributo próprio (força).
        return "[CHEFE] " + super().ficha() + f"\nForça: {self.forca}"