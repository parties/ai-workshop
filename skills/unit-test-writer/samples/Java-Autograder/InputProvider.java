import java.io.*;
import java.lang.*;
import java.util.*;
import java.nio.charset.Charset;

/**
 * This class provides an InputStream to mock System.in.
 * It stores its own InputStream internally, which is created from a String, or array
 * of strings, then feeds it to the running program.
 */
public class InputProvider extends InputStream
{

    private Autograder prog;
    private InputStream input;

    /**
     * Setups up a provider for input.
     */
    public InputProvider()
    {
        super();
    }

    public void clearInput() throws IOException
    {
        this.input.reset();
    }

    /**
     * Creates an InputStream from the array of inputs and assigns to
     * `input`
     * @param inputStrings ArrayList<String>
     */
    public void setInputs(String[] inputStrings)
    {
        String inputString = String.join("\n", inputStrings) + "\n";
        byte b [] = inputString.getBytes(Charset.forName("UTF-8"));
        input = new ByteArrayInputStream(b);
    }

    /**
     * Adds a single string to the InputStream.
     * Because they can't be concatenated, it copies everything over into a new
     * InputStream.
     * @param inputString String
     */
    public void addInput(String inputString)
    {
        try {
            inputString += "\n";

            if (input == null)
            {
                input = new ByteArrayInputStream(inputString.getBytes(Charset.forName("UTF-8")));
            }
            // convert input to bytebuffer in order to concat
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int nRead;
            byte[] data = new byte[0xFFFF];
            while ((nRead = input.read(data, 0, data.length)) != -1) {
                buffer.write(data, 0, nRead);
            }

            byte [] inputBytes = inputString.getBytes(Charset.forName("UTF-8"));
            byte [] oldInput = buffer.toByteArray();
            byte [] newInput = new byte[oldInput.length + inputBytes.length];
            System.arraycopy(oldInput, 0, newInput, 0, oldInput.length);
            System.arraycopy(inputBytes, 0, newInput, oldInput.length, inputBytes.length);
            input = new ByteArrayInputStream(newInput);
        } catch(IOException e) {
            return;
        }
    }

    /**
     * The below functions are overrides of the InputStream functions.
     * These are what Scanners (or anything) use when reading from an InputStream.
     * The most commonly used one is the second, read(byte[], int, int).
     */
    @Override
    public int read() throws IOException
    {
        return this.input.read();
    }

    @Override
    public int read(byte[] data, int offset, int length) throws IOException
    {
        return this.input.read(data, offset, length);
    }

    @Override
    public int read(byte[] data) throws IOException {
        return this.input.read(data);
    }

    @Override
    public long skip(long bytesToSkip) throws IOException {
         return this.input.skip(bytesToSkip);
    }
}
