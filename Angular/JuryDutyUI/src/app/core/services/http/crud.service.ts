import { HttpClient, HttpErrorResponse } from '@angular/common/http';

export abstract class CrudService<T = any> {
    abstract endpoint;
    url = "http://localhost:8080";

    protected constructor(protected http: HttpClient) {}

    public async get<G>(request?: string): Promise<G | null> {
        let response = null;
        try {
            if(request) {
                response = await this.http
                    .get<G>(`${this.url}/${this.endpoint}?${request}`)
                    .toPromise();
            }
            else {
                response = await this.http
                    .get<G>(`${this.url}/${this.endpoint}`)
                    .toPromise();
            }
        } catch (error) {
            response = this.errorHandler('GET', error);
        }
        return response;
    }

    public async getList(): Promise<T[] | null> {
        return this.get<T[]>('list');
    }

    public async getById(id: number | string): Promise<T | null> {
        return this.get<T>('' + id);
    }

    public async post(body,resType?:string): Promise<any> {
        let response = null;
        try {
            if (resType) {
                response = await this.http
                .post(`${this.url}/${this.endpoint}`, body, { responseType: 'text'})
                .toPromise();
            } else {
                response = await this.http
                .post(`${this.url}/${this.endpoint}`, body)
                .toPromise();
            }
           
        } catch (error) {
            response = this.errorHandler('POST', error);
        }
        return response;
    }

    public async deleteById(id: number | string): Promise<any> {
        let response = null;
        try {
            response = await this.http
                .delete(`${this.url}/${this.endpoint}/${id}`)
                .toPromise();
        } catch (error) {
            response = this.errorHandler('DELETE', error);
        }
        return response;
    }

    public errorHandler(
        method: string,
        error: HttpErrorResponse,
    ): Promise<never> {
        console.error(
            `Error occurred during ${method} ${this.url}/${this.endpoint}`,
            error,
        );
        return Promise.reject(error);
    }
}
