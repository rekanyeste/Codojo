private boolean ChangePassword(){
        if (!passwordE.equals(editPwd.getText().toString())){
            databaseReference.child(usernameE).child("password").setValue(editPwd.getText().toString());
            passwordE = editPwd.getText().toString();
            return true;
        } else {
            return false;
        }
    }