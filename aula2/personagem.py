class Personagem:
   def __init__(self, nome, vida, forca):
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
   def atacar(self, alvo):
      alvo.receber_dano(self.forca)
if __name__ == '__main__':
    heroi = Personagem("Herói", 100, 10)
    chefe = Personagem("Chefe", 150, 15)

    print("|===Antes da batalha==|")
    heroi.ficha()
    chefe.ficha()

    while heroi.estavivo() and chefe.estavivo():
        heroi.atacar(chefe)
        if chefe.estavivo():
           chefe.atacar(heroi)

    print("|==Depois da batalha==|")
    heroi.ficha()
    chefe.ficha()

    if heroi.estavivo():
       print("O herói venceu o confronto!")
    else:
       print("O chefão venceu o confronto!")
