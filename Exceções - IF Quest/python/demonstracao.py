"""
Aula 6 P1 - Tratamento de Exceções no IF Quest (versão Python)

Uso de IA: usei o Claude (Anthropic) para entender a diferença entre
exceções checked/unchecked (conceito equivalente em Java, já que
Python não tem exceções verificadas), revisar erros de sintaxe da
versão Java, desenhar o método agir() como alternativa ao isinstance
dentro do laço da batalha, e portar tudo para Python. Validei
manualmente rodando o programa e conferindo cada mensagem de erro
capturada no console.
"""

from mago import Mago
from guerreiro import Guerreiro
from chefe import Chefe
from sem_mana_error import SemManaError
from item import Item
from item_nao_encontrado_error import ItemNaoEncontradoError


def iniciar_turno_com_item(heroi, nome_item):
    # Desafio C (equivalente Python): esta função NÃO trata a
    # exceção, ela deixa propagar - quem decide tratar de fato é
    # quem chama esta função (o main, mais abaixo). Documentando
    # aqui porque em Python isso não é forçado pelo compilador
    # como em Java (throws), é uma escolha de design.
    print(f"{heroi.get_nome()} tenta usar o item: {nome_item}")
    resultado = heroi.usar_item(nome_item)
    print(resultado)


def main():
    # Exercício 2: criação protegida de personagens
    try:
        heroi = Mago("Arthemis", -100, 5)
    except ValueError as e:
        print(f"Erro ao criar personagem: {e}")

    try:
        heroi2 = Guerreiro("Zyrian", 100, 6)
    except ValueError as e:
        print(f"erro ao criar personagem: {e}")

    herois = []
    elara = Mago("Frieren", 80, 5)
    thalos = Guerreiro("Darkin", 90, 6)
    herois.append(elara)
    herois.append(thalos)

    rei_lich = Chefe("Rei Lich")

    # Exercícios 3 e 4: um único laço, sem isinstance, cada turno
    # dentro de try/except/finally.
    for heroi in herois:
        print(heroi.ficha())
        print(f"{heroi.get_nome()} usa {heroi.habilidade()}")

        try:
            heroi.agir(rei_lich)
        except SemManaError as e:
            print(f"{heroi.get_nome()} tentou lançar magia mas ficou sem mana: {e}")
            print(f"{heroi.get_nome()} perde o turno!")
        finally:
            print(f"Fim do turno de {heroi.get_nome()}.")
        print("---")

    print(rei_lich.ficha())

    # Demonstração explícita do Exercício 3
    print("\n-- Testando Mago sem mana suficiente --")
    elara.set_mana(5)
    try:
        elara.agir(rei_lich)
    except SemManaError as e:
        print(f"{elara.get_nome()} tentou lançar magia mas ficou sem mana: {e}")
        print(f"{elara.get_nome()} perde o turno! {thalos.get_nome()} ataca no lugar dele.")
        thalos.agir(rei_lich)
    finally:
        print("Fim do turno.")

    # isinstance aqui é aceitável porque é uma checagem específica,
    # avulsa, que não repete comportamento genérico. Dentro do laço
    # da batalha isso não seria aceitável, porque ali o objetivo é
    # tratar todos os heróis de forma uniforme através do mesmo
    # comando (ficha(), habilidade(), agir()); usar isinstance lá
    # quebraria o polimorfismo.
    print("\n-- Consulta de mana dos magos --")
    for heroi in herois:
        if isinstance(heroi, Mago):
            print(f"{heroi.get_nome()} tem {heroi.get_mana()} de mana.\n")

    print("Teste de exceção: tentando criar um item com bônus negativo...")
    try:
        item_invalido = Item("Espada celestial", -5)
    except ValueError as e:
        print(f"Erro ao criar item: {e}")

    # Desafio A: catch direto, dois casos (item que o herói tem e um que não tem)
    thalos.pegar(Item("Poção de cura", 10))
    try:
        print(thalos.usar_item("Poção de cura"))
    except ItemNaoEncontradoError as e:
        print(f"Erro: {e}")
    try:
        print(thalos.usar_item("Espada Lendária"))
    except ItemNaoEncontradoError as e:
        print(f"Erro: {e}")

    # Desafio C: chamando via iniciar_turno_com_item, que propaga a
    # exceção em vez de tratar - o except de verdade acontece só aqui.
    try:
        iniciar_turno_com_item(elara, "Cajado Arcano")
    except ItemNaoEncontradoError as e:
        print(f"Erro (via repasse da função): {e}")


if __name__ == "__main__":
    main()