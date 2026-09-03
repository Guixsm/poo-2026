class Personagem:
    def __init__(self):
        self._nome = None
        self._vida = None
        self._nivel = None
        self._inventario = []

    def pegar(self, item):
        self._inventario.append(item)

    @property
    def inventario(self):
        return self._inventario

    def ficha(self):
        resultado = "Nome: " + str(self.nome) + "\n" + \
        "Vida: " + str(self.vida) + "\n" + \
        "Nível: " + str(self.nivel) + "\n" + \
        "Inventário: "

        for item in self.inventario:
                resultado += "\n- " + item.descricao()
        return resultado
    
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
    def vida(self):
        return self._vida
    
    @vida.setter
    def vida(self, valor):
        if 0 <= valor <= 100:
            self._vida = valor
        else:
            print("Erro de validação")

    @property
    def nivel(self):
        return self._nivel
    
    @nivel.setter
    def nivel(self, valor):
        if valor >= 1:
            self._nivel = valor 
        else:
            print("Erro de validação")

    def receber_dano(self, dano):
            self.vida -= dano