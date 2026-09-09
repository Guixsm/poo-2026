class Item:
    def __init__(self, nome, bonus):
        self.set_nome(nome)
        self.set_bonus(bonus)

    def get_nome(self):
        return self.nome

    def set_nome(self, nome):
        if not nome:
            print("Nome inválido")
        else:
            self.nome = nome

    def get_bonus(self):
        return self.bonus

    def set_bonus(self, bonus):
        if bonus >= 0:
            self.bonus = bonus
        else:
            print("Bonus inválido")

    def descricao(self):
        return f"{self.nome} (+{self.bonus})"