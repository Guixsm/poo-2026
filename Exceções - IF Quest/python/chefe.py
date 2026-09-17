from personagem import Personagem

class Chefe(Personagem):
    def __init__(self, nome):
        super().__init__(nome, 200, 10)
        self.forca = 20

    def get_forca(self):
        return self.forca

    def habilidade(self):
        return "ataque devastador"

    def ficha(self):
        return "[CHEFE] " + super().ficha() + f"\nForça: {self.forca}"