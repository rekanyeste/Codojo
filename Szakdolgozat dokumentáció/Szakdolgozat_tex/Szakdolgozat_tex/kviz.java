valasz1.setOnClickListener(view -> {
            if(kvizLista.get(pozicio).getMegoldas().trim().equalsIgnoreCase(valasz1.getText().toString().trim())){
                pontszam++;
            }
            probalkozas++;
            pozicio = rnd.nextInt(kvizLista.size());
            dataToViews(pozicio);
        });