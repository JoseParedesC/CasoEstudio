import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { ActivatedRoute, Router } from "@angular/router";
import { Categoria } from "src/app/core/models/categoria";
import { AlertService } from "src/app/core/services/alert.service";
import { CategoriaService } from "src/app/core/services/categoria.service";
import { UserService } from "src/app/core/services/user.service";
import { Productos } from "src/app/shared/models/Productos";
import { ProductService } from "src/app/shared/services/producto.service";
import { CurrencyPipe } from '@angular/common';

@Component({
    selector: 'vendedor-form-product',
    templateUrl: './products.form.html',
    styleUrls: ['./products.form.scss']
})
export class ProductoForm implements OnInit{
    id: number;
    productForm : FormGroup;
    categorias : Categoria[] = [];
    constructor(
        private formBuilder: FormBuilder,
        private _producto: ProductService,
        private _categoria: CategoriaService,
        private _user : UserService,
        private _alert: AlertService,
        private router: Router,
        private route: ActivatedRoute,
        private pipe : CurrencyPipe
    ){
        this.productForm = this.formBuilder.group({
            id: [0],
            nombre: ['', Validators.required],
            presentacion: ['', Validators.required],
            contenido: ['', Validators.required],
            porcentajeAlcohol: ['', Validators.required],
            cantidad: [0, Validators.required],
            precio: [0, Validators.required],
            codigo: ['', Validators.required],
            fechaVencimiento: ['', Validators.required],
            categoria: ['', Validators.required],
            vendedor: [''],
            descripcion: ['', Validators.required],
            foto: ['']
        });
        this.id = +this.route.snapshot.params.id;
    }

    ngOnInit(){
        this.getCategorias();
        this.getProduct();
        this.setPipeForm();
    }

    //Start Selects
    getCategorias(){
        this._categoria.getAll()
            .subscribe(response => this.categorias = response.body);
    }
    //End Selects

    submit(){
        const producto : Productos = this.productForm.value;
        producto.vendedor = {id : this._user.getUser().id};
        producto.categoria = {id : this.productForm.get('categoria').value }
        producto.foto = document.getElementById('image').getAttribute('src');
        producto.precio = this.productForm.get('precio').value.replace(/[,]/g, '');
        //producto.porcentajeAlcohol = this.productForm.get('porcentajeAlcohol').value.replace(',', '.');
        this._producto.saveProducto(producto).
            subscribe(() => {
                this._alert.success('Se ha guardado el producto');
                this.router.navigateByUrl('/vendedor/products');
            }, badRequest => {
                this._alert.error(badRequest);
            })
    }

    getProduct(){
        if(this.id){
            this._producto.getProductById(this.id)
                .subscribe((response) => {
                    this.setValuesForm(response.body);
                    document.getElementById('image').setAttribute('src', response.body.foto);
                }, badRequest => {
                    this._alert.error(badRequest.error);
                })
        }
    }

    setValuesForm(producto : Productos){
        this.productForm.get('id').setValue(producto.id);
        this.productForm.get('nombre').setValue(producto.nombre);
        this.productForm.get('precio').setValue(producto.precio);
        this.productForm.get('cantidad').setValue(producto.cantidad);
        this.productForm.get('codigo').setValue(producto.codigo);
        this.productForm.get('fechaVencimiento').setValue(producto.fechaVencimiento);
        this.productForm.get('categoria').setValue(producto.categoria.id);
        this.productForm.get('descripcion').setValue(producto.descripcion);
        this.productForm.get('vendedor').setValue(producto.vendedor.id);
        this.productForm.get('porcentajeAlcohol').setValue(producto.porcentajeAlcohol);
        this.productForm.get('presentacion').setValue(producto.presentacion);
        this.productForm.get('contenido').setValue(producto.contenido);
    }

    setImage(event){
        var image = document.getElementById('image');
        var file = event.target.files[0];
        const reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => {
            image.setAttribute('src', reader.result.toString());
            image.style.display = 'block';
        }
    }

    setPipeForm(){
        this.productForm.get('precio').valueChanges
            .subscribe((data) => {
                this.productForm.patchValue({
                    precio : this.pipe.transform(
                        data.toString().replace(/\D/g, '').replace(/^0+/, ''),
                        '',
                        '',
                        '1.0-0'
                    )
                }, { emitEvent: false })
            })
    }
}