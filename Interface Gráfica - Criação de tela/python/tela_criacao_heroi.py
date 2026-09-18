"""
Aula 6 P2 - Interface Gráfica com OO: A Tela de Criação de Herói (Tkinter)

Uso de IA: usei o Claude (Anthropic) para aprender o conceito de Tk
e os gerenciadores de layout do Tkinter (pack/grid), e ajudar a
estruturar a tela. Validei manualmente executando o programa e
conferindo a janela e a saída no console.
"""

import tkinter as tk

class TelaCriacaoHeroi(tk.Tk):
    def __init__(self):
        
        super().__init__()
        self.title("IF Quest")
        self.geometry("400x300")

       
        self.rotulo_titulo = tk.Label(self, text="Novo Herói", font=("Arial", 14))
        self.rotulo_titulo.pack(side="top", pady=10)

        
        painel_formulario = tk.Frame(self)
        painel_formulario.pack(side="top", pady=10)

        tk.Label(painel_formulario, text="Nome:").grid(row=0, column=0, padx=5, pady=5)
        self.campo_nome = tk.Entry(painel_formulario)
        self.campo_nome.grid(row=0, column=1, padx=5, pady=5)

        tk.Label(painel_formulario, text="Vida inicial:").grid(row=1, column=0, padx=5, pady=5)
        self.campo_vida = tk.Entry(painel_formulario)
        self.campo_vida.grid(row=1, column=1, padx=5, pady=5)

        tk.Label(painel_formulario, text="Classe (Mago/Guerreiro):").grid(row=2, column=0, padx=5, pady=5)
        self.campo_classe = tk.Entry(painel_formulario)
        self.campo_classe.grid(row=2, column=1, padx=5, pady=5)

      .
        self.botao_criar = tk.Button(self, text="Criar Herói", state="disabled")
        self.botao_criar.pack(side="bottom", pady=10)

        self.rotulo_titulo.config(text="Criação de Herói")
        self.campo_nome.insert(0, "Digite o nome aqui")
        print("Texto atual do campo nome:", self.campo_nome.get())


if __name__ == "__main__":
    tela = TelaCriacaoHeroi()
    tela.mainloop()