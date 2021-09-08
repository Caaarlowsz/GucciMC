package me.Pedro.ScoreBoard;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class FrameAnimatedString implements AnimatableString
{
    protected List<String> frames;
    protected int currentFrame;
    
    public FrameAnimatedString() {
        this.frames = new ArrayList<String>();
        this.currentFrame = -1;
    }
    
    public FrameAnimatedString(final String... frames) {
        this.frames = new ArrayList<String>();
        this.currentFrame = -1;
        this.frames = Arrays.asList(frames);
    }
    
    public FrameAnimatedString(final List<String> frames) {
        this.frames = new ArrayList<String>();
        this.currentFrame = -1;
        this.frames = frames;
    }
    
    public void addFrame(final String string) {
        this.frames.add(string);
    }
    
    public void setFrame(final int frame, final String string) {
        this.frames.set(frame, string);
    }
    
    public void removeFrame(final String string) {
        this.frames.remove(string);
    }
    
    public int getCurrentFrame() {
        return this.currentFrame;
    }
    
    public void setCurrentFrame(final int currentFrame) {
        this.currentFrame = currentFrame;
    }
    
    public int getTotalLength() {
        return this.frames.size();
    }
    
    public String getString(final int frame) {
        return this.frames.get(frame);
    }
    
    @Override
    public String current() {
        if (this.currentFrame == -1) {
            return null;
        }
        return this.frames.get(this.currentFrame);
    }
    
    @Override
    public String next() {
        ++this.currentFrame;
        if (this.currentFrame == this.frames.size()) {
            this.currentFrame = 0;
        }
        return this.frames.get(this.currentFrame);
    }
    
    @Override
    public String previous() {
        --this.currentFrame;
        if (this.currentFrame == -1) {
            this.currentFrame = this.frames.size() - 1;
        }
        return this.frames.get(this.currentFrame);
    }
}
