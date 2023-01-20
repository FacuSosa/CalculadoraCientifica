package com.app.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.app.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Calculator)
        super.onCreate(savedInstanceState)
       binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.b1.setOnClickListener {

            binding.tvMain.text = (binding.tvMain.text.toString() + "1")
        }

        binding.b2.setOnClickListener {

            binding.tvMain.text = (binding.tvMain.text.toString() + "2")
        }

        binding.b3.setOnClickListener {

            binding.tvMain.text = (binding.tvMain.text.toString() + "3")
        }

        binding.b4.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "4")
        }

        binding.b5.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "5")
        }

        binding.b6.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "6")
        }

        binding.b7.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "7")
        }

        binding.b8.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "8")
        }

        binding.b9.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "9")
        }
        binding.b0.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "0")
        }

        binding.bdot.setOnClickListener {
            if (binding.tvMain.text.toString().isNullOrEmpty()) {
                it.isFocusable
            } else {
                binding.tvMain.text = (binding.tvMain.text.toString() + ".")
            }
        }

        binding.bplus.setOnClickListener {
            if (binding.tvMain.text.toString().isNullOrEmpty()) {
                it.isFocusable
            } else {
            binding.tvMain.text = (binding.tvMain.text.toString() + "+")
        }
        }

        binding.bdiv.setOnClickListener {
            if (binding.tvMain.text.toString().isNullOrEmpty()) {
                it.isFocusable
            } else {
                binding.tvMain.text = (binding.tvMain.text.toString() + "/")
            }
        }

        binding.bbrac1.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "(")
        }

        binding.bbrac2.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + ")")
        }

        binding.bpi.setOnClickListener {

            binding.tvMain.text = (binding.tvMain.text.toString() + "3.142")
            binding.tvsec.text = (binding.bpi.text.toString())
        }
        binding.bsin.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "sin")
            if(binding.tvMain.text.toString().isNullOrEmpty()){
                Toast.makeText(this, "Ingrese un numero correctamente", Toast.LENGTH_SHORT).show()
            }
        }
        binding.bcos.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "cos")
        }
        binding.btan.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "tan")
        }
        binding.binv.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "^" + "(-1)")
        }
        binding.bln.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "ln")
        }
        binding.blog.setOnClickListener {
            binding.tvMain.text = (binding.tvMain.text.toString() + "log")
        }

        binding.bminus.setOnClickListener {
            if (binding.tvMain.text.toString().isNullOrEmpty()) {
                it.isFocusable
            } else {

                val str: String = binding.tvMain.text.toString()
                if (!str.get(index = str.length - 1).equals("-")) {
                    binding.tvMain.text = (binding.tvMain.text.toString() + "-")
                }
            }
        }

        binding.bmul.setOnClickListener {
            if (binding.tvMain.text.toString().isNullOrEmpty()) {
                it.isFocusable
            } else {

                val str: String = binding.tvMain.text.toString()
                if (!str.get(index = str.length - 1).equals("*")) {
                    binding.tvMain.text = (binding.tvMain.text.toString() + "*")
                }
            }
        }

        binding.bsqrt.setOnClickListener {
            if (binding.tvMain.text.toString().isEmpty()) {

                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {
                val str: String = binding.tvMain.text.toString()

                val r = Math.sqrt(str.toDouble())

                val result = r.toString()
                binding.tvMain.setText(result)
            }
        }
        binding.bequal.setOnClickListener {
            if (binding.tvMain.text.toString().isNullOrEmpty()) {
                it.isFocusable
            } else {
                val str: String = binding.tvMain.text.toString()

                val result: Double = evaluate(str)

                val r = result.toString()
                binding.tvMain.setText(r)
                binding.tvsec.text = str
            }
        }
        binding.bac.setOnClickListener {

            binding.tvMain.setText("")
            binding.tvsec.setText("")
        }
        binding.bc.setOnClickListener {

            var str: String = binding.tvMain.text.toString()
            if (!str.equals("")) {
                str = str.substring(0, str.length - 1)
                binding.tvMain.text = str
            }
        }
        binding.bsquare.setOnClickListener {
            if (binding.tvMain.text.toString().isEmpty()) {

                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {

                val d: Double = binding.tvMain.getText().toString().toDouble()

                val square = d * d

                binding.tvMain.setText(square.toString())

                binding.tvsec.text = "$d²"
            }
        }
        binding.bfact.setOnClickListener {
            if (binding.tvMain.text.toString().isEmpty()) {

                Toast.makeText(this, "Please enter a valid number..", Toast.LENGTH_SHORT).show()
            } else {

                val value: Int = binding.tvMain.text.toString().toInt()
                val fact: Int = factorial(value)
                binding.tvMain.setText(fact.toString())
                binding.tvsec.text = "$value`!"
            }

        }

    }

    fun factorial(n: Int): Int {

        return if (n == 1 || n == 0) 1 else n * factorial(n - 1)
    }

    fun evaluate(str: String): Double {
        return object : Any() {

            var pos = -1
            var ch = 0


            fun nextChar() {

                ch = if (++pos < str.length) str[pos].toInt() else -1
            }


            fun eat(charToEat: Int): Boolean {
                while (ch == ' '.toInt()) nextChar()

                if (ch == charToEat) {
                    nextChar()
                    return true
                }
                return false
            }


            fun parse(): Double {
                nextChar()
                val x = parseExpression()
                if (pos < str.length) throw RuntimeException("Unexpected: " + ch.toChar())
                return x
            }


            fun parseExpression(): Double {
                var x = parseTerm()
                while (true) {
                    if (eat('+'.toInt())) x += parseTerm()
                    else if (eat('-'.toInt())) x -= parseTerm()
                    else return x
                }
            }


            fun parseTerm(): Double {
                var x = parseFactor()
                while (true) {
                    if (eat('*'.toInt())) x *= parseFactor()
                    else if (eat('/'.toInt())) x /= parseFactor()
                    else return x
                }
            }


            fun parseFactor(): Double {

                if (eat('+'.toInt())) return parseFactor()
                if (eat('-'.toInt())) return -parseFactor()

                var x: Double

                val startPos = pos

                if (eat('('.toInt())) {
                    x = parseExpression()
                    eat(')'.toInt())
                } else if (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) {

                    while (ch >= '0'.toInt() && ch <= '9'.toInt() || ch == '.'.toInt()) nextChar()

                    x = str.substring(startPos, pos).toDouble()
                } else if (ch >= 'a'.toInt() && ch <= 'z'.toInt()) {

                    while (ch >= 'a'.toInt() && ch <= 'z'.toInt()) nextChar()
                    val func = str.substring(startPos, pos)

                    x = parseFactor()

                    x =
                        if (func == "sqrt") Math.sqrt(x)

                        else if (func == "sin") Math.sin(
                            Math.toRadians(x)

                        ) else if (func == "cos") Math.cos(
                            Math.toRadians(x)

                        ) else if (func == "tan")
                            Math.tan(Math.toRadians(x))

                        else if (func == "log")
                            Math.log10(x)

                        else if (func == "ln") Math.log(x)

                        else throw RuntimeException(
                            "Unknown function: $func"
                        )
                } else {

                    throw RuntimeException("Unexpected: " + ch.toChar())
                }

                if (eat('^'.toInt())) x = Math.pow(x, parseFactor())
                return x
            }

        }.parse()
    }
}

