
palabra = input("Ingresa una palabra: ")
letra = input("Ingresa una letra para buscar: ")


contador = 0


for caracter in palabra:

    if caracter == letra:
        contador += 1


print(f"La letra '{letra}' aparece {contador} veces en la palabra '{palabra}'.")

