.data
heap: .space 4096
.text
.global _start
_start:
adr x10, heap
// Declarando variable: puntos de tipo: int
// Estoy en ExpInteger
// Constante: 0
MOV x0, #0
STR x0, [SP, #-8]!
// Imprimir
// Estoy en ExpString === Archivo de prueba básico ===
STR x10, [SP, #-8]!
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 65 - (A) en la posicion x10
MOV w0, #65
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 104 - (h) en la posicion x10
MOV w0, #104
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 118 - (v) en la posicion x10
MOV w0, #118
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 100 - (d) en la posicion x10
MOV w0, #100
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 112 - (p) en la posicion x10
MOV w0, #112
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 117 - (u) en la posicion x10
MOV w0, #117
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 98 - (b) en la posicion x10
MOV w0, #98
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 98 - (b) en la posicion x10
MOV w0, #98
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 225 - (á) en la posicion x10
MOV w0, #225
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 115 - (s) en la posicion x10
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString Validaciones manuales esperadas: 4
STR x10, [SP, #-8]!
// Guardando el caracter 86 - (V) en la posicion x10
MOV w0, #86
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 100 - (d) en la posicion x10
MOV w0, #100
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 115 - (s) en la posicion x10
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 109 - (m) en la posicion x10
MOV w0, #109
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 117 - (u) en la posicion x10
MOV w0, #117
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 115 - (s) en la posicion x10
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 115 - (s) en la posicion x10
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 112 - (p) en la posicion x10
MOV w0, #112
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 100 - (d) en la posicion x10
MOV w0, #100
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 115 - (s) en la posicion x10
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 58 - (:) en la posicion x10
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 52 - (4) en la posicion x10
MOV w0, #52
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString ==== Declaración de variables ====
STR x10, [SP, #-8]!
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 68 - (D) en la posicion x10
MOV w0, #68
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 243 - (ó) en la posicion x10
MOV w0, #243
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 100 - (d) en la posicion x10
MOV w0, #100
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 118 - (v) en la posicion x10
MOV w0, #118
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 98 - (b) en la posicion x10
MOV w0, #98
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 115 - (s) en la posicion x10
MOV w0, #115
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 61 - (=) en la posicion x10
MOV w0, #61
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Declarando variable: puntosDeclaracion de tipo: int
// Estoy en ExpInteger
// Constante: 0
MOV x0, #0
STR x0, [SP, #-8]!
// Imprimir
// Estoy en ExpString Declaración explícita con tipo y valor
STR x10, [SP, #-8]!
// Guardando el caracter 68 - (D) en la posicion x10
MOV w0, #68
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 243 - (ó) en la posicion x10
MOV w0, #243
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 120 - (x) en la posicion x10
MOV w0, #120
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 112 - (p) en la posicion x10
MOV w0, #112
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 237 - (í) en la posicion x10
MOV w0, #237
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 112 - (p) en la posicion x10
MOV w0, #112
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 121 - (y) en la posicion x10
MOV w0, #121
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 118 - (v) en la posicion x10
MOV w0, #118
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Declarando variable: entero de tipo: int
// Estoy en ExpInteger
// Constante: 42
MOV x0, #42
STR x0, [SP, #-8]!
// Declarando variable: decimal de tipo: float64
// Estoy en Decimal 3.14
MOVZ x0, #34079, LSL #0
MOVK x0, #20971, LSL #16
MOVK x0, #7864, LSL #32
MOVK x0, #16393, LSL #48
STR x0, [SP, #-8]!
// Declarando variable: texto de tipo: string
// Estoy en ExpString Hola!
STR x10, [SP, #-8]!
// Guardando el caracter 72 - (H) en la posicion x10
MOV w0, #72
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 33 - (!) en la posicion x10
MOV w0, #33
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Declarando variable: booleano de tipo: bool
// Estoy en ExpBoolean true
MOV x0, #1
STR x0, [SP, #-8]!
// Declarando variable: caracter de tipo: rune
// Estoy en ExpBoolean A
STR x10, [SP, #-8]!
// Guardando el caracter 65 - (A) en la posicion x10
MOV w0, #65
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Imprimir
// Estoy en ExpString \n\n###Validacion Manual
STR x10, [SP, #-8]!
// Guardando el caracter 92 - (\) en la posicion x10
MOV w0, #92
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 92 - (\) en la posicion x10
MOV w0, #92
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 35 - (#) en la posicion x10
MOV w0, #35
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 35 - (#) en la posicion x10
MOV w0, #35
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 35 - (#) en la posicion x10
MOV w0, #35
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 86 - (V) en la posicion x10
MOV w0, #86
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 100 - (d) en la posicion x10
MOV w0, #100
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 77 - (M) en la posicion x10
MOV w0, #77
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 117 - (u) en la posicion x10
MOV w0, #117
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString entero:
STR x10, [SP, #-8]!
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 58 - (:) en la posicion x10
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
MOV x0, #32
ADD x0, sp, x0
// Estoy en un ID: entero puntero: 32
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV X0, x0
BL print_integer
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString decimal:
STR x10, [SP, #-8]!
// Guardando el caracter 100 - (d) en la posicion x10
MOV w0, #100
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 109 - (m) en la posicion x10
MOV w0, #109
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 58 - (:) en la posicion x10
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
MOV x0, #24
ADD x0, sp, x0
// Estoy en un ID: decimal puntero: 24
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR d0, [SP], #8
BL print_double
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString texto:
STR x10, [SP, #-8]!
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 120 - (x) en la posicion x10
MOV w0, #120
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 58 - (:) en la posicion x10
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
MOV x0, #16
ADD x0, sp, x0
// Estoy en un ID: texto puntero: 16
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString booleano:
STR x10, [SP, #-8]!
// Guardando el caracter 98 - (b) en la posicion x10
MOV w0, #98
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 58 - (:) en la posicion x10
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
MOV x0, #8
ADD x0, sp, x0
// Estoy en un ID: booleano puntero: 8
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV X0, x0
BL print_boolean
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString caracter:
STR x10, [SP, #-8]!
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 58 - (:) en la posicion x10
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
MOV x0, #0
ADD x0, sp, x0
// Estoy en un ID: caracter puntero: 0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Imprimir
// Estoy en ExpString 
STR x10, [SP, #-8]!
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
// Estoy en If
// Estoy en And
// Estoy en And
// Estoy en And
// Estoy en And
MOV x0, #32
ADD x0, sp, x0
// Estoy en un ID: entero puntero: 32
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Estoy en ExpInteger
// Constante: 42
MOV x0, #42
STR x0, [SP, #-8]!
LDR x1, [SP], #8
LDR x0, [SP], #8
CMP x0, x1
BEQ L0
MOV x0, #0
STR x0, [SP, #-8]!
B L1
L0:
MOV x0, #1
STR x0, [SP, #-8]!
L1:
LDR x0, [SP], #8
CMP x0, #0
BEQ L2
// Estoy en Relacional
MOV x0, #24
ADD x0, sp, x0
// Estoy en un ID: decimal puntero: 24
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Estoy en Decimal 3.0
MOVZ x0, #0, LSL #0
MOVK x0, #0, LSL #16
MOVK x0, #0, LSL #32
MOVK x0, #16392, LSL #48
STR x0, [SP, #-8]!
LDR d1, [SP], #8
LDR d0, [SP], #8
FCMP d0, d1
BGT L4
MOV x0, #0
STR x0, [SP, #-8]!
B L5
L4:
MOV x0, #1
STR x0, [SP, #-8]!
L5:
LDR x0, [SP], #8
CMP x0, #0
BEQ L2
MOV x0, #1
B L3
L2:
MOV x0, #0
L3:
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #0
BEQ L6
MOV x0, #16
ADD x0, sp, x0
// Estoy en un ID: texto puntero: 16
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Estoy en ExpString Hola!
STR x10, [SP, #-8]!
// Guardando el caracter 72 - (H) en la posicion x10
MOV w0, #72
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 33 - (!) en la posicion x10
MOV w0, #33
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x1, [SP], #8
LDR x0, [SP], #8
CMP x0, x1
BEQ L8
MOV x0, #0
STR x0, [SP, #-8]!
B L9
L8:
MOV x0, #1
STR x0, [SP, #-8]!
L9:
LDR x0, [SP], #8
CMP x0, #0
BEQ L6
MOV x0, #1
B L7
L6:
MOV x0, #0
L7:
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #0
BEQ L10
MOV x0, #8
ADD x0, sp, x0
// Estoy en un ID: booleano puntero: 8
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Estoy en ExpBoolean true
MOV x0, #1
STR x0, [SP, #-8]!
LDR x1, [SP], #8
LDR x0, [SP], #8
CMP x0, x1
BEQ L12
MOV x0, #0
STR x0, [SP, #-8]!
B L13
L12:
MOV x0, #1
STR x0, [SP, #-8]!
L13:
LDR x0, [SP], #8
CMP x0, #0
BEQ L10
MOV x0, #1
B L11
L10:
MOV x0, #0
L11:
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CMP x0, #0
BEQ L14
MOV x0, #0
ADD x0, sp, x0
// Estoy en un ID: caracter puntero: 0
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Estoy en ExpBoolean A
STR x10, [SP, #-8]!
// Guardando el caracter 65 - (A) en la posicion x10
MOV w0, #65
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x1, [SP], #8
LDR x0, [SP], #8
CMP x0, x1
BEQ L16
MOV x0, #0
STR x0, [SP, #-8]!
B L17
L16:
MOV x0, #1
STR x0, [SP, #-8]!
L17:
LDR x0, [SP], #8
CMP x0, #0
BEQ L14
MOV x0, #1
B L15
L14:
MOV x0, #0
L15:
STR x0, [SP, #-8]!
LDR x0, [SP], #8
CBZ x0, L18
// Estoy en un bloque de instrucciones
// Asignando variable: puntosDeclaracion
// Estoy en AddSub
// Evaluando expresión izquierda
MOV x0, #48
ADD x0, sp, x0
// Estoy en un ID: puntosDeclaracion puntero: 48
LDR x0, [x0, #0]
STR x0, [SP, #-8]!
// Evaluando expresión derecha
// Estoy en ExpInteger
// Constante: 1
MOV x0, #1
STR x0, [SP, #-8]!
LDR x0, [SP], #8
LDR x1, [SP], #8
ADD x0, x1, x0
STR x0, [SP, #-8]!
LDR x0, [SP], #8
MOV x1, #48
ADD x1, sp, x1
STR x0, [x1, #0]
STR x0, [SP, #-8]!
// Imprimir
// Estoy en ExpString OK Declaración explícita: correcto
STR x10, [SP, #-8]!
// Guardando el caracter 79 - (O) en la posicion x10
MOV w0, #79
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 75 - (K) en la posicion x10
MOV w0, #75
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 68 - (D) en la posicion x10
MOV w0, #68
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 243 - (ó) en la posicion x10
MOV w0, #243
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 110 - (n) en la posicion x10
MOV w0, #110
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 120 - (x) en la posicion x10
MOV w0, #120
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 112 - (p) en la posicion x10
MOV w0, #112
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 108 - (l) en la posicion x10
MOV w0, #108
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 237 - (í) en la posicion x10
MOV w0, #237
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 105 - (i) en la posicion x10
MOV w0, #105
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 97 - (a) en la posicion x10
MOV w0, #97
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 58 - (:) en la posicion x10
MOV w0, #58
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 32 - ( ) en la posicion x10
MOV w0, #32
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 114 - (r) en la posicion x10
MOV w0, #114
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 101 - (e) en la posicion x10
MOV w0, #101
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 99 - (c) en la posicion x10
MOV w0, #99
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 116 - (t) en la posicion x10
MOV w0, #116
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 111 - (o) en la posicion x10
MOV w0, #111
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
// Guardando el caracter 0 - ( ) en la posicion x10
MOV w0, #0
STRB w0, [x10]
MOV x0, #1
ADD x10, x10, x0
LDR x0, [SP], #8
MOV X0, x0
BL print_string
// Salto de línea
ADR x1, newline
MOV x2, #1
MOV x0, #1
MOV w8, #64
SVC #0
L18:
MOV x0, #0
MOV x8, #93
SVC #0

//--------------------------------------------------------------
// print_string - Prints a null-terminated string to stdout
//
// Input:
//   x0 - The address of the null-terminated string to print
//--------------------------------------------------------------
print_string:
    // Save link register and other registers we'll use
    stp     x29, x30, [sp, #-16]!
    stp     x19, x20, [sp, #-16]!
    
    // x19 will hold the string address
    mov     x19, x0
    
print_loop:
    // Load a byte from the string
    ldrb    w20, [x19]
    
    // Check if it's the null terminator (0)
    cbz     w20, print_done
    
    // Prepare for write syscall
    mov     x0, #1              // File descriptor: 1 for stdout
    mov     x1, x19             // Address of the character to print
    mov     x2, #1              // Length: 1 byte
    mov     x8, #64             // syscall: write (64 on ARM64)
    svc     #0                  // Make the syscall
    
    // Move to the next character
    add     x19, x19, #1
    
    // Continue the loop
    b       print_loop
    
print_done:

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0

    // Restore saved registers
    ldp     x19, x20, [sp], #16
    ldp     x29, x30, [sp], #16
    ret
    // Return to the caller
    

//--------------------------------------------------------------
// print_integer - Prints a signed integer to stdout
//
// Input:
//   x0 - The integer value to print
//--------------------------------------------------------------
print_integer:
    // Save registers
    stp x29, x30, [sp, #-16]!  // Save frame pointer and link register
    stp x19, x20, [sp, #-16]!  // Save callee-saved registers
    stp x21, x22, [sp, #-16]!
    stp x23, x24, [sp, #-16]!
    stp x25, x26, [sp, #-16]!
    stp x27, x28, [sp, #-16]!
    
    // Check if number is negative
    mov x19, x0                // Save original number
    cmp x19, #0                // Compare with zero
    bge positive_number        // Branch if greater or equal to zero
    
    // Handle negative number
    mov x0, #1                 // fd = 1 (stdout)
    adr x1, minus_sign         // Address of minus sign
    mov x2, #1                 // Length = 1
    mov w8, #64                // Syscall write
    svc #0
    
    neg x19, x19               // Make number positive
    
positive_number:
    // Prepare buffer for converting result to ASCII
    sub sp, sp, #32            // Reserve space on stack
    mov x22, sp                // x22 points to buffer
    
    // Initialize digit counter
    mov x23, #0                // Digit counter
    
    // Handle special case for zero
    cmp x19, #0
    bne convert_loop
    
    // If number is zero, just write '0'
    mov w24, #48               // ASCII '0'
    strb w24, [x22, x23]       // Store in buffer
    add x23, x23, #1           // Increment counter
    b print_result             // Skip conversion loop
    
convert_loop:
    // Divide the number by 10
    mov x24, #10
    udiv x25, x19, x24         // x25 = x19 / 10 (quotient)
    msub x26, x25, x24, x19    // x26 = x19 - (x25 * 10) (remainder)
    
    // Convert remainder to ASCII and store in buffer
    add x26, x26, #48          // Convert to ASCII ('0' = 48)
    strb w26, [x22, x23]       // Store digit in buffer
    add x23, x23, #1           // Increment digit counter
    
    // Prepare for next iteration
    mov x19, x25               // Quotient becomes the new number
    cbnz x19, convert_loop     // If number is not zero, continue
    
    // Reverse the buffer since digits are in reverse order
    mov x27, #0                // Start index
reverse_loop:
    sub x28, x23, x27          // x28 = length - current index
    sub x28, x28, #1           // x28 = length - current index - 1
    
    cmp x27, x28               // Compare indices
    bge print_result           // If crossed, finish reversing
    
    // Swap characters
    ldrb w24, [x22, x27]       // Load character from start
    ldrb w25, [x22, x28]       // Load character from end
    strb w25, [x22, x27]       // Store end character at start
    strb w24, [x22, x28]       // Store start character at end
    
    add x27, x27, #1           // Increment start index
    b reverse_loop             // Continue reversing
    
print_result:
    // Print the result
    mov x0, #1                 // fd = 1 (stdout)
    mov x1, x22                // Buffer address
    mov x2, x23                // Buffer length
    mov w8, #64                // Syscall write
    svc #0

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0
    
    // Clean up and restore registers
    add sp, sp, #32            // Free buffer space
    ldp x27, x28, [sp], #16    // Restore callee-saved registers
    ldp x25, x26, [sp], #16
    ldp x23, x24, [sp], #16
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16    // Restore frame pointer and link register
    ret                        // Return to caller
    

//--------------------------------------------------------------
// print_double - Prints a double precision float to stdout
//
// Input:
//   d0 - The double value to print
//--------------------------------------------------------------

print_double:
    // Save context
    stp x29, x30, [sp, #-16]!    
    stp x19, x20, [sp, #-16]!
    stp x21, x22, [sp, #-16]!
    stp x23, x24, [sp, #-16]!
    
    // Check if number is negative
    fmov x19, d0
    tst x19, #(1 << 63)       // Comprueba el bit de signo
    beq skip_minus

    // Print minus sign
    mov x0, #1
    adr x1, minus_sign
    mov x2, #1
    mov x8, #64
    svc #0

    // Make value positive
    fneg d0, d0

skip_minus:
    // Convert integer part
    fcvtzs x0, d0             // x0 = int(d0)
    bl print_integer

    // Print dot '.'
    mov x0, #1
    adr x1, dot_char
    mov x2, #1
    mov x8, #64
    svc #0

    // Get fractional part: frac = d0 - float(int(d0))
    frintm d4, d0             // d4 = floor(d0)
    fsub d2, d0, d4           // d2 = d0 - floor(d0) (exact fraction)

    // Para 2.5, d2 debe ser exactamente 0.5

    // Multiplicar por 1_000_000 (6 decimales)
    movz x1, #0x000F, lsl #16
    movk x1, #0x4240, lsl #0   // x1 = 1000000
    scvtf d3, x1              // d3 = 1000000.0
    fmul d2, d2, d3           // d2 = frac * 1_000_000
    
    // Redondear al entero más cercano para evitar errores de precisión
    frintn d2, d2             // d2 = round(d2)
    fcvtzs x0, d2             // x0 = int(d2)

    // Imprimir ceros a la izquierda si es necesario
    mov x20, x0               // x20 = fracción entera
    movz x21, #0x0001, lsl #16
    movk x21, #0x86A0, lsl #0  // x21 = 100000
    mov x22, #0               // inicializar contador de ceros
    mov x23, #10              // constante para división

leading_zero_loop:
    udiv x24, x20, x21        // x24 = x20 / x21
    cbnz x24, done_leading_zeros  // Si hay un dígito no cero, salir del bucle

    // Imprimir '0'
    mov x0, #1
    adr x1, zero_char
    mov x2, #1
    mov x8, #64
    svc #0

    udiv x21, x21, x23        // x21 /= 10
    add x22, x22, #1          // incrementar contador de ceros
    cmp x21, #0               // verificar si llegamos al final
    beq print_remaining       // si divisor es 0, saltar a imprimir el resto
    b leading_zero_loop

done_leading_zeros:
    // Print the remaining fractional part
    mov x0, x20
    bl print_integer
    b exit_function

print_remaining:
    // Caso especial cuando la parte fraccionaria es 0 después de imprimir ceros
    cmp x20, #0
    bne exit_function
    
    // Ya imprimimos todos los ceros necesarios
    // No hace falta imprimir nada más

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0

exit_function:
    // Restore context
    ldp x23, x24, [sp], #16
    ldp x21, x22, [sp], #16
    ldp x19, x20, [sp], #16
    ldp x29, x30, [sp], #16
    ret
    

//--------------------------------------------------------------
// print_boolean - Prints a bool (true/false) to stdout
//
// Input:
//   x0 - The bool value to print (0 = false, != 0 = true)
//--------------------------------------------------------------
print_boolean:
    cmp x0, #0
    bne .print_true

.print_false:
    adr x1, str_false
    mov x2, #5
    b .print

.print_true:
    adr x1, str_true
    mov x2, #4

.print:
    mov x0, #1          // fd = stdout
    mov w8, #64         // syscall write
    svc #0

    //adr x1, newline
    //mov x2, #1
    //mov x0, #1
    //mov w8, #64
    //svc #0

    ret
    
newline: .ascii "\n"
minus_sign: .ascii "-"
dot_char: .ascii "."
zero_char: .ascii "0"
str_true: .ascii "true"
str_false: .ascii "false"
