import { Productos } from "src/app/shared/models/Productos";

export interface Carro{
    producto: any,
    carroCompra: any,
    cantidad: number
}

interface CarroPadre{
    id: number,
    total: number
}