from Personagem import Personagem

class Guerreiro(Personagem):
    def __init__(self, nome, vida, nivel):
        super().__init__()
        self.nome = nome
        self.vida = vida
        self.nivel = nivel
        self._defesa = 5
    @property
    def defesa(self):
        return self._defesa
    @defesa.setter
    def defesa(self, valor):
        if valor < 0:
            print("Defesa inválida")
        else:
            self._defesa = valor

    def receber_dano(self, dano):
        super().receber_dano(max(0, dano - self._defesa))

    def ficha(self):
       return super().ficha() + "\nDefesa: " + str(self._defesa)
