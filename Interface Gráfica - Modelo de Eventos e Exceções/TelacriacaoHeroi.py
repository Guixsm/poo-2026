"""
Aula 7 P1 - Interface Gráfica: Modelo de Eventos e Exceções

Uso de IA: utilizei ChatGPT para compreender o modelo de eventos
do Tkinter, o tratamento de exceções e a integração da interface
gráfica com as classes Guerreiro e Personagem.

A ferramenta de IA também foi utilizada para auxiliar na
estruturação e revisão do código. A implementação foi modificada
e validada manualmente, incluindo a execução do programa e os
testes de entradas válidas e inválidas, do clique do botão e
da tecla Enter.
"""

import tkinter as tk
from tkinter import messagebox


class Personagem:
    def __init__(self, nome, vida, nivel):
        self.set_nome(nome)
        self.set_vida(vida)
        self.nivel = nivel

    def set_nome(self, nome):
        if nome is None or nome == "":
            raise ValueError("O nome não pode estar vazio!")
        self.nome = nome

    def set_vida(self, vida):
        if vida < 0 or vida > 200:
            raise ValueError(
                f"A vida deve estar entre 0 e 200. "
                f"Valor fornecido: {vida}"
            )
        self.vida = vida

    def get_nome(self):
        return self.nome

    def get_vida(self):
        return self.vida


class Guerreiro(Personagem):
    def __init__(self, nome, vida, nivel):
        super().__init__(nome, vida, nivel)
        self.defesa = 5


class TelaCriacaoHeroi(tk.Tk):

    def __init__(self):
        super().__init__()

        self.title("IF Quest")
        self.geometry("400x350")

        self.rotulo_titulo = tk.Label(
            self,
            text="Criação de Herói"
        )
        self.rotulo_titulo.pack(side="top")

        painel_formulario = tk.Frame(self)
        painel_formulario.pack(expand=True)

        tk.Label(
            painel_formulario,
            text="Nome:"
        ).grid(row=0, column=0, padx=5, pady=5)

        self.campo_nome = tk.Entry(painel_formulario)
        self.campo_nome.grid(row=0, column=1, padx=5, pady=5)

        tk.Label(
            painel_formulario,
            text="Vida inicial:"
        ).grid(row=1, column=0, padx=5, pady=5)

        self.campo_vida = tk.Entry(painel_formulario)
        self.campo_vida.grid(row=1, column=1, padx=5, pady=5)

        tk.Label(
            painel_formulario,
            text="Classe (Mago/Guerreiro):"
        ).grid(row=2, column=0, padx=5, pady=5)

        self.campo_classe = tk.Entry(painel_formulario)
        self.campo_classe.grid(row=2, column=1, padx=5, pady=5)

    
        self.rotulo_resultado = tk.Label(
            self,
            text="Preencha os dados e crie o herói."
        )
        self.rotulo_resultado.pack()

        self.botao_criar = tk.Button(
            self,
            text="Criar Herói",
            command=self.criar_heroi
        )
        self.botao_criar.pack(side="bottom", pady=10)

        self.campo_vida.bind(
            "<Return>",
            lambda evento: self.criar_heroi()
        )

    def criar_heroi(self):
        try:
           
            nome = self.campo_nome.get()
            texto_vida = self.campo_vida.get()

            vida = int(texto_vida)

    
            guerreiro = Guerreiro(nome, 0, 1)

            guerreiro.set_vida(vida)

            self.rotulo_resultado.config(
                text=(
                    f"Herói criado: "
                    f"{guerreiro.get_nome()} - "
                    f"Vida: {guerreiro.get_vida()}"
                )
            )

        except ValueError as ex:

            if texto_vida and not texto_vida.lstrip("-").isdigit():
                messagebox.showerror(
                    "Erro",
                    "Vida deve ser um número!"
                )
            else:
                messagebox.showerror(
                    "Erro",
                    str(ex)
                )


if __name__ == "__main__":
    tela = TelaCriacaoHeroi()
    tela.mainloop()