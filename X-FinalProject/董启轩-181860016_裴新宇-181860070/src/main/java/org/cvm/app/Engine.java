package org.cvm.app;

import javafx.animation.AnimationTimer;
import org.omg.CORBA.PUBLIC_MEMBER;

public class Engine {

    private final Timer timer;

    private double nowNanos;
    private double lastNanos;
    private double deltaNanos;

    // Frames Per Second
    private double fps;
    // Nanos Per Frame
    private double npf;

    OnStart onStart;
    OnUpdate onUpdate;
    OnStop onStop;

    public Engine(double fps) {
        timer = new Timer();
        setFPS(fps);
    }
    //默认60帧
    public Engine() {
        this(60);
    }

    public double getNowNanos() {
        return nowNanos;
    }

    public double getNowMillis() {
        return nowNanos * 1E-6;
    }

    public double getNowSecs() {
        return nowNanos * 1E-9;
    }

    public double getLastNanos() {
        return lastNanos;
    }

    public double getLastMillis() {
        return lastNanos * 1E-6;
    }

    public double getLastSecs() {
        return lastNanos * 1E-9;
    }

    public double getDeltaNanos() {
        return deltaNanos;
    }

    public double getDeltaMillis() {
        return deltaNanos * 1E-6;
    }

    public double getDeltaSecs() {
        return deltaNanos * 1E-9;
    }

    public double getFPS() {
        return fps;
    }
    public void setFPS(double fps) {
        this.fps = fps;
        this.npf = 1E9 / fps;
    }

    void start() {
        timer.start();
    }
    void handle(long now) {
        timer.handle(now);
    }
    public void stop() {
        timer.stop();
    }
    void reset() {
        timer.reset();
    }

    private final class Timer extends AnimationTimer {
        @Override
        public void start() {
            this.reset();
            super.start();

            if (onStart != null) {
                onStart.handle();
            }
        }

        @Override
        public void handle(long now) {
            nowNanos = now;
            if (lastNanos > 0) {
                deltaNanos += nowNanos - lastNanos;
            }
            lastNanos = nowNanos;

            if (deltaNanos >= npf) {
                if (onUpdate != null) {
                    onUpdate.handle(deltaNanos);
                }
                deltaNanos -= npf;

            }
        }

        @Override
        public void stop() {
            if (onStop != null) {
                onStop.handle();
            }
            super.stop();
            this.reset();
        }

        public void reset() {
            nowNanos = 0;
            lastNanos = 0;
            deltaNanos = 0;
        }
    }

    static interface OnStart {
        void handle();
    }

    static interface OnUpdate {
        void handle(double time);
    }

    static interface OnStop {
        void handle();
    }
}
