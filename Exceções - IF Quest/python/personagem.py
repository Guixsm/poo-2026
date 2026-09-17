from abc import ABC, abstractmethod
from item_nao_encontrado_error import ItemNaoEncontradoError

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
            raise ValueError("O nome não pode estar vazio!")
        self.nome = nome

    def set_vida(self, v):
        if v < 0 or v > 200:
            raise ValueError(f"A vida deve estar entre 0 e 200. Valor fornecido: {v}")
        self.vida = v

    def set_nivel(self, n):
        if n < 1:
            raise ValueError(f"O nível deve ser maior ou igual a 1. Valor fornecido: {n}")
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

    def usar_item(self, nome_item):
        for item in self.inventario:
            if item.get_nome().lower() == nome_item.lower():
                return f"{self.get_nome()} usa {item.descricao()}!"
        raise ItemNaoEncontradoError(nome_item)

    @abstractmethod
    def habilidade(self):
        pass

    def agir(self, alvo):
        # Comportamento padrão: ataque físico. Mago sobrescreve para
        # tentar lançar magia (pode levantar SemManaError). Em Python
        # não existe "throws" (exceção verificada), então documento
        # aqui: agir() pode levantar SemManaError quando sobrescrito
        # pelo Mago, e é tratado no laço da batalha (demonstracao.py),
        # não aqui dentro, porque só quem está no laço sabe o que
        # fazer quando um herói fica sem mana (ex: perder o turno).
        dano = self.get_nivel() * 10
        alvo.receber_dano(dano)
        print(f"{self.get_nome()} ataca {alvo.get_nome()} causando {dano} de dano!")