package com.marcreis.cursomc.domain.enums;

public enum TipoCliente  {

    PESSOAFISICA(1,"Pessoa Fisica"),
    PESSOAJURIDICA(2,"Pessoa Juridica");

    private int cod;
    private  String descricao;

    TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static TipoCliente toEnum(Integer id){

        if(id ==null){
            return null;
        }

        for(TipoCliente x : TipoCliente.values()){

            if(id.equals(x.getCod())){
                return x;
            }

            throw new IllegalAccessException("Id invalido " + id);
        }

    }

}
