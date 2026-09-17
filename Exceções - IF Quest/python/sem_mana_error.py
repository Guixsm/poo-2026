class SemManaError(Exception):
    def __init__(self, mana):
        super().__init__(f"O personagem não possui mana suficiente para realizar a ação. Mana atual: {mana}")