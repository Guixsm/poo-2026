class ItemNaoEncontradoError(Exception):
    def __init__(self, nome_item):
        super().__init__(f"Item não encontrado no inventário: {nome_item}")