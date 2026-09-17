from personagem import Personagem
from sem_mana_error import SemManaError

class Mago(Personagem):
    def __init__(self, nome, vida, nivel):
        super().__init__(nome, vida, nivel)
        self.mana = 50

    def get_mana(self):
        return self.mana

    def set_mana(self, mana):
        if mana < 0:
            raise ValueError(f"A mana não pode ser negativa: {mana}")
        self.mana = mana

    def ficha(self):
        return super().ficha() + f"\nMana: {self.mana}"

    def habilidade(self):
        return "rajada arcana"

    def lancar_magia(self, custo):
        if custo > self.mana:
            raise SemManaError(self.mana)
        self.mana -= custo
        return f"Magia lançada com sucesso! custo: {custo}, mana restante: {self.mana}"

    def agir(self, alvo):
        resultado = self.lancar_magia(20)
        print(resultado)
        dano = self.get_nivel() * 15
        alvo.receber_dano(dano)
        print(f"{self.get_nome()} atinge {alvo.get_nome()} com magia causando {dano} de dano!")