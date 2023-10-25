class Ahorcado:

    def __init__(self, palabra="", intentos=5):
        self.palabra_secreta = self.quitar_acentos(palabra.lower())  
        self.palabra_usuario = "?" * len(self.palabra_secreta)
        self.intentos = intentos

    def imprimir_estado(self):
        print(self.palabra_usuario)
        print("Le quedan", self.intentos, "intentos")

    def quitar_acentos(self, palabra):
        acento = ["á", "é", "í", "ó", "ú"]
        remplazo = ["a", "e", "i", "o", "u"]
        for i in range(len(acento)):
            palabra = palabra.replace(acento[i], remplazo[i])
        return palabra

    def pedir_letra(self):
        letra = input("Digite una letra: ")
        return self.quitar_acentos(letra.lower())  

    def buscar_letra(self, letra):
        veces = 0
        for i in range(len(self.palabra_secreta)):
            if self.palabra_secreta[i] == letra:
                veces += 1
                self.palabra_usuario = self.palabra_usuario[:i] + letra + self.palabra_usuario[i+1:]
        return veces

    def determinar_si_gano(self):
        return "?" not in self.palabra_usuario

    def jugar(self):
        while not self.determinar_si_gano() and self.intentos > 0:
            self.imprimir_estado()
            letra = self.pedir_letra()
            veces = self.buscar_letra(letra)
            if veces == 0:
                self.intentos -= 1

        if self.determinar_si_gano():
            print("¡Ganaste! La palabra era:", self.palabra_secreta)
        else:
            print("Perdiste. La palabra era:", self.palabra_secreta)

def main():
    palabra = "paralelepípedo"  
    ahorcado = Ahorcado(palabra)
    ahorcado.jugar()

if __name__ == "__main__":
    main()
