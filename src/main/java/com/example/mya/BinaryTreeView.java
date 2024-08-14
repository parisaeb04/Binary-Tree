//BinaryTreeView

package com.example.mya;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class BinaryTreeView extends View {
    private BST.TreeNode root;
    private Paint paintNode;
    private Paint paintLine;
    private int highlightValue;


    public BinaryTreeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paintNode = new Paint();
        paintNode.setColor(Color.rgb(200,180,222));
        paintNode.setStyle(Paint.Style.FILL);
        paintNode.setAntiAlias(true);

        paintLine = new Paint();
        paintLine.setColor(Color.rgb(87,19,135));
        paintLine.setStrokeWidth(4);
        paintLine.setStyle(Paint.Style.STROKE);
        paintLine.setTextSize(35);
        paintLine.setAntiAlias(true);
    }

    public void setRoot(BST.TreeNode root) {
        this.root = root;
        invalidate();
    }

    public void setHighlightValue(int highlightValue) {
        this.highlightValue = highlightValue;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (root != null) {
            drawTree(canvas, root, getWidth() / 2, 50, getWidth() / 4);
        }
    }

    private void drawTree(Canvas canvas, BST.TreeNode node, float x, float y, float offsetX) {
        if (node == null) return;

        Paint nodePaint = (node.getValue() == highlightValue) ? getHighlightPaint() : paintNode;

        canvas.drawCircle(x, y, 40, nodePaint);
        canvas.drawText(String.valueOf(node.getValue()), x - 18, y + 9, paintLine);

        if (node.getLeft() != null) {
            float newX = x - offsetX;
            float newY = y + 150;
            canvas.drawLine(x, y + 40, newX, newY - 40, paintLine);
            drawTree(canvas, node.getLeft(), newX, newY, offsetX / 2);
        }

        if (node.getRight() != null) {
            float newX = x + offsetX;
            float newY = y + 150;
            canvas.drawLine(x, y + 40, newX, newY - 40, paintLine);
            drawTree(canvas, node.getRight(), newX, newY, offsetX / 2);
        }
    }

    private Paint getHighlightPaint() {
        Paint highlightPaint = new Paint();
        highlightPaint.setColor(Color.rgb(168,90,242));
        highlightPaint.setStyle(Paint.Style.FILL);
        highlightPaint.setAntiAlias(true);
        return highlightPaint;
    }
}

