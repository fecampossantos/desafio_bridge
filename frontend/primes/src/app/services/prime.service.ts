import { Injectable } from "@angular/core";
import { HttpClient } from "@angular/common/http";

import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';

import { PrimeDTO } from "../../models/prime.dto";



@Injectable()
export class PrimeService {

    constructor(
        public http: HttpClient,
        ){}


    findAll(){
        return this.http.get<PrimeDTO[]>(`http://localhost:8080/`)
    }

    findById(id){
        return this.http.get<PrimeDTO[]>(`http://localhost:8080/${id}`)
    }

    add(low, top) {
        const body = {
            "lowerRange": ""+low,
            "topRange": ""+top
        }
        return this.http.post(`http://localhost:8080/`, body)
    }

    getByLowTop(low, top) {
        return this.http.get<PrimeDTO>(`http://localhost:8080/${low}/${top}`)
    }

    delete(id){
        return this.http.delete(`http://localhost:8080/${id}`)
    }

}