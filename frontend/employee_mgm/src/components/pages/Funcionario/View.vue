<template>
    <div class="funcionarioview">
        <div class="col-md-12">

            <div align="center">
                <div class="col-md-12 animated fadeIn" align="center">
                    <div class="jumbotron">
                        <h3 class="display-4">Detalhes do Funcionário</h3>
                        <p class="lead">Informações do funcionário. </p>
                        <hr class="my-1">
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12 animated fadeIn">
                    <fieldset>
                        <legend>Dados do Funcionário</legend>

                        <div align="center">
                            <img class="img-circle" src="https://cdn1.iconfinder.com/data/icons/avatar-3/512/Manager-512.png" name="aboutme" width="128px" height="128px" border="0"></a>
                            <hr>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="nomeFuncionario">Nome do Funcionário</label>
                                <input type="text" class="form-control col-md-8" required id="nomeFuncionario" v-model="funcionario.nomeFuncionario" disabled>
                            </div>

                            <div class="form-group col-md-4">
                                <label for="cargo">Cargo</label>
                                <input type="text" class="form-control col-md-8" required id="cargo" v-model="funcionario.funcionarioCargo.dscCargo" disabled>
                            </div>

                        </div>

                        <div class="row">
                            <div class="form-group col-md-2">
                                <label for="salarioFuncionario">Salário do Funcionário</label>
                                <input type="text" v-mask="'R$ ####.##'" class="form-control col-md-8" required id="salarioFuncionario" v-model="funcionario.salarioFuncionario" disabled>
                            </div>
                        </div>

                        <div class="row">
                            <div class="form-group col-md-2">
                                <label for="salarioCalculadoFuncionario">Salário Calculado do Funcionário</label>
                                <input type="text" v-mask="'R$ ####.##'" class="form-control col-md-8" required id="salarioCalculadoFuncionario" v-model="funcionario.salarioCalculadoFuncionario" disabled>
                            </div>
                        </div>
                        <hr>

                        <a class="btn btn-primary btn-md text-white">Desativar Funcionário</a>
                    </fieldset>
                </div>
            </div>

            <br />

            <div class="row">
                <div class="col-md-6 animated bounceInDown">
                    <fieldset>
                        <legend>Incidencias do Funcionário</legend>

                        <div align="right">
                            <img class="img-circle" src="https://cdn3.iconfinder.com/data/icons/banking-finance-flat-circle-vol-5/100/profile__avatar__person__money__salary-512.png" name="aboutme" width="48px" height="48px" border="0"></a>
                            <hr>
                        </div>

                        <table class="table table-hover table-striped">
                            <thead class="thead-inverse">
                                <tr>
                                    <th>Incidência</th>
                                    <th>Valor</th>
                                    <th>Tipo de Incidência</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="ic in funcionario.funcionarioInncidenciasSalario" v-bind:key="ic.idIncidenciaSalario">
                                    <td>{{ic.nomeIncidenciaSalario}}</td>
                                    <td>R$ {{ic.valorIncidenciaSalario}}</td>
                                    <td>{{ic.tipoIncidenciaSalario}}</td>
                                </tr>
                            </tbody>
                        </table>
                    </fieldset>
                </div>

                <div class="col-md-6 animated bounceInDown">
                    <fieldset>
                        <legend>Incidencias do Cargo</legend>

                        <div align="right">
                            <img class="img-circle" src="https://cdn3.iconfinder.com/data/icons/banking-finance-flat-circle-vol-5/100/profile__avatar__person__money__salary-512.png" name="aboutme" width="48px" height="48px" border="0"></a>
                            <hr>
                        </div>

                        <table class="table table-hover table-striped">
                            <thead class="thead-inverse">
                                <tr>
                                    <th>Incidência</th>
                                    <th>Valor</th>
                                    <th>Tipo de Incidência</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr v-for="ic in funcionario.funcionarioCargo.cargoIncidenciasSalario" v-bind:key="ic.idIncidenciaSalario">
                                    <td>{{ic.nomeIncidenciaSalario}}</td>
                                    <td>R$ {{ic.valorIncidenciaSalario}}</td>
                                    <td>{{ic.tipoIncidenciaSalario}}</td>
                                </tr>
                            </tbody>
                        </table>
                    </fieldset>
                </div>
            </div>

            <router-link class="btn btn-success" to="/funcionario/all">Voltar</router-link>

        </div>
    </div>
</template>

<script>
import { mask } from 'vue-the-mask'
export default {
    name: 'funcionarioview',

    data() {
        return {
            salarioCalculadoFormatado: '',
            salarioFormatado: '',
            funcionario: {
                nomeFuncionario: '',
                salarioFuncionario: '',
                salarioCalculadoFuncionario: '',
                dataNascimento: '',
                funcionarioCargo: '',
                funcionarioInncidenciasSalario: []
            }
        }
    },

    mounted() {
        this.getFuncionarioById();
    },

    methods: {

        getFuncionarioById() {
            fetch(`http://localhost:8080/employee-management/funcionario/${this.$route.params.funcionarioId}`)
                .then(response => response.json().then(data => { console.log(data); this.funcionario = data }))
                .catch(error => { console.log(error) })
        },

        desativarFuncionario() {

        }

    }

}
</script>

<style scoped>

</style>
