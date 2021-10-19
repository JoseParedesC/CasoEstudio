import { TestBed } from '@angular/core/testing';
import { ProductService } from '../shared/services/producto.service';
import { HttpTestingController, HttpClientTestingModule } from '@angular/common/http/testing'
import { HttpClient } from '@angular/common/http';

fdescribe('ProductService', () => {
    let httpClient : HttpClient;
    let testingController : HttpTestingController;
    let service : ProductService;

    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [ HttpClientTestingModule ]
        });
        httpClient = TestBed.get(HttpClient);
        testingController = TestBed.get(HttpTestingController);
        service = TestBed.get(ProductService);
    });
    
    it('should be created', () => {
        expect(service).toBeTruthy();
    })

    describe('get all products', () => {
        //arrange
    });
})