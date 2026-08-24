class PersonaEncapsulado:
    def __init__(self):
        self._nome = None
        self._vida = None
        self._nivel = None

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

if __name__ == "__main__":
    p = PersonaEncapsulado()


print("\n===|Valores válidos|===\n")

p.nome = "Frieren"
p.vida = 100
p.nivel = 50

print("Nome:", p.nome)
print("Vida:", p.vida)
print("Nível:", p.nivel)

print("\n===|Valores inválidos|===\n")

p.nome = ""
p.vida = 150
p.nivel = 0