class Personagem:

   def __init__(self, nome = "Frieren", vida = 100, forca = 10):
      self.nome = nome
      self.vida = vida
      self.forca = forca

   def receber_dano(self, dano):
      self.vida -= dano
      if self.vida < 0:
         self.vida = 0

   def estavivo(self):
       return self.vida > 0
   
   def ficha(self):
      print("Nome:", self.nome)
      print("Vida:", self.vida)
      print("Força:", self.forca)
      print()

   def atacar(self, alvo = None, dano = None):
      if dano is None:
         dano = self.forca
      print(f"{self.nome} atacou causando {dano} de dano!")
      if alvo is not None:
         alvo.receber_dano(dano)



if __name__ == '__main__':
    heroi = Personagem("Herói", 100, 10)
    chefe = Personagem("Chefe", 150, 15)
    Frieren = Personagem()

    print("\n|===Teste de sobrecarga de métodos===|\n")
    Frieren.atacar()
    Frieren.atacar(dano = 25)

    print("\n|===Antes da batalha==|\n")
    heroi.ficha()
    chefe.ficha()

    while heroi.estavivo() and chefe.estavivo():
        heroi.atacar(alvo = chefe)
        if chefe.estavivo():
           chefe.atacar(heroi)

    print("\n|==Depois da batalha==|\n")
    heroi.ficha()
    chefe.ficha()

    if heroi.estavivo():
       print("O herói venceu o confronto!")
    else:
       print("O chefão venceu o confronto!")
