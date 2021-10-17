import { Productos } from "src/app/shared/models/Productos";

export interface Carro{
    producto: Productos,
    carroCompra: any
}

interface CarroPadre{
    id: number,
    total: number
}