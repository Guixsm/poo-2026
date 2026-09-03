class Item:
    def __init__(self, nome, bonus):
        self.nome = nome
        self.bonus = bonus

    @property
    def nome(self):
        return self._nome

    @nome.setter
    def nome(self, valor):
        if valor is None or valor == "":
            print("Erro de validação")
        else:
            self._nome = valor

    @property
    def bonus(self):
        return self._bonus

    @bonus.setter
    def bonus(self, valor):
        if valor < 0:
            print("bônus não deve ser menor que zero")
        else:
            self._bonus = valor

    def descricao(self):
        return self._nome + " (+" + str(self._bonus) + ")"
