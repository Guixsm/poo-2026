"""
Aula_05 - Polimorfismo: A Batalha Final do IF Quest (versão Python)

Uso de IA: usei o Claude (Anthropic) para me auxiliar na transição de Java
(classes Personagem/Item/Mago/Guerreiro/Chefe) para Python (ABC e
@abstractmethod), e corrigir algumas lacunas que tinha no laço da batalha final.
"""

from mago import Mago
from guerreiro import Guerreiro
from chefe import Chefe

def main():
    herois = []
    frieren = Mago("Frieren", 80, 5)
    darkin = Guerreiro("Darkin", 90, 6)
    herois.append(frieren)
    herois.append(darkin)

    rei_lich = Chefe("Rei Lich")

    for heroi in herois:
        print(heroi.ficha())
        print(f"{heroi.get_nome()} usa {heroi.habilidade()}")

        dano = heroi.get_nivel() * 10
        rei_lich.receber_dano(dano)
        print(f"{heroi.get_nome()} ataca o Rei Lich causando {dano} de dano!")
        print("---")

    print(rei_lich.ficha())

    print("\n-- Consulta de mana dos magos --")
    for heroi in herois:
        if isinstance(heroi, Mago):
            print(f"{heroi.get_nome()} tem {heroi.get_mana()} de mana.")

if __name__ == "__main__":
    main()