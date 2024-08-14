//MainActivity

package com.example.mya;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.mya.BinaryTreeView;

public class MainActivity extends AppCompatActivity {

    private BinaryTreeView binaryTreeView;
    private EditText insertEditText, deleteEditText;
    private BST bst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binaryTreeView = findViewById(R.id.binaryTreeView);
        insertEditText = findViewById(R.id.insertEditText);
        deleteEditText = findViewById(R.id.deleteEditText);

        bst = new BST();
        binaryTreeView.setRoot(bst.getRoot());
    }

    public void onInsert(View view) {
        String valueStr = insertEditText.getText().toString();
        if (!valueStr.isEmpty()) {
            int value = Integer.parseInt(valueStr);
            bst.insert(value);
            binaryTreeView.setRoot(bst.getRoot());
            binaryTreeView.setHighlightValue(value);
            Toast.makeText(this, "Number added to the tree", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
    }

    public void onDelete(View view) {
        String valueStr = deleteEditText.getText().toString();
        if (!valueStr.isEmpty()) {
            int value = Integer.parseInt(valueStr);
            bst.delete(value);
            binaryTreeView.setRoot(bst.getRoot());
            Toast.makeText(this, "Number deleted from the tree", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();

    }
}