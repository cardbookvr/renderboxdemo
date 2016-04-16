package com.cardbookvr.renderbox;

import android.app.Activity;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.util.Log;

import com.cardbookvr.renderbox.components.RenderObject;
import com.google.vrtoolkit.cardboard.CardboardView;
import com.google.vrtoolkit.cardboard.Eye;
import com.google.vrtoolkit.cardboard.HeadTransform;
import com.google.vrtoolkit.cardboard.Viewport;

import java.util.ArrayList;
import java.util.List;

import javax.microedition.khronos.egl.EGLConfig;

/**
 * Created by Schoen and Jonathan on 4/16/2016.
 */
public class RenderBox implements CardboardView.StereoRenderer {
    private static final String TAG = "RenderBox";

    public static RenderBox instance;
    public Activity mainActivity;
    IRenderBox callbacks;

    public List<RenderObject> renderObjects = new ArrayList<RenderObject>();


    public RenderBox(Activity mainActivity, IRenderBox callbacks){
        instance = this;
        this.mainActivity = mainActivity;
        this.callbacks = callbacks;
    }

    @Override
    public void onNewFrame(HeadTransform headTransform) {

    }

    @Override
    public void onDrawEye(Eye eye) {

    }

    @Override
    public void onFinishFrame(Viewport viewport) {

    }

    @Override
    public void onSurfaceChanged(int i, int i1) {

    }

    @Override
    public void onSurfaceCreated(EGLConfig eglConfig) {

    }

    @Override
    public void onRendererShutdown() {

    }

    /**
     * Checks if we've had an error inside of OpenGL ES, and if so
     what that error is.
     * @param label Label to report in case of error.
     */
    public static void checkGLError(String label) {
        int error;
        while ((error = GLES20.glGetError()) !=
                GLES20.GL_NO_ERROR) {
            String errorText = String.format("%s: glError %d, %s",
                    label, error, GLU.gluErrorString(error));
            Log.e(TAG, errorText);
            throw new RuntimeException(errorText);
        }
    }
}
