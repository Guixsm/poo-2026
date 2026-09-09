from abc import ABC, abstractmethod

class Personagem(ABC):
    def __init__(self, nome, vida, nivel):
        self.set_nome(nome)
        self.set_vida(vida)
        self.set_nivel(nivel)
        self.inventario = []

    def get_nome(self):
        return self.nome

    def get_vida(self):
        return self.vida

    def get_nivel(self):
        return self.nivel

    def set_nome(self, nome):
        if not nome:
            print("ERRO DE VALIDAÇAO!")
        else:
            self.nome = nome

    def set_vida(self, v):
        # Limite ampliado para 200 (em vez de 100) para acomodar o
        # Chefe, que nasce com 200 de vida.
        if 0 <= v <= 200:
            self.vida = v
        else:
            print("ERRO DE VALIDAÇAO!")

    def set_nivel(self, n):
        if n < 1:
            print("ERRO DE VALIDAÇAO!")
        else:
            self.nivel = n

    def ficha(self):
        resultado = f"Nome: {self.nome}\nVida: {self.vida}\nNível: {self.nivel}\nInventário: "
        for item in self.inventario:
            resultado += f"\n- {item.descricao()}"
        return resultado

    def receber_dano(self, dano):
        self.vida -= dano

    def pegar(self, item):
        self.inventario.append(item)

    # Exercício 1: método abstrato. Personagem herda de ABC e usa
    # @abstractmethod, então Personagem("Zé", 10, 1) não pode mais
    # ser instanciado diretamente (lança TypeError).
    @abstractmethod
    def habilidade(self):
        pass