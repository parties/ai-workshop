---
name: cyber-lab-builder
description: >
  Builds complete, ready-to-use interactive cybersecurity lab packages for a high school
  cybersecurity class (grades 9-12, dual credit). Use this skill whenever the user asks to
  create, design, build, or draft a cybersecurity lab, activity, or hands-on exercise.
  Also trigger when the user mentions specific tools or techniques and wants students to
  explore them (e.g., "I want students to practice nmap," "make a Metasploit lab," "build
  something for password cracking," "design a Wireshark activity"). Output is a complete lab
  package: (1) a dual-track student lab document with Beginner and Advanced pathways, both
  semi-guided but at different densities, rendered as both Markdown and an HTML artifact;
  (2) a teacher setup and facilitation guide; (3) a Google Forms reflection question list.
---

# Cyber Lab Builder

Generates complete, student-ready cybersecurity lab packages for Eric's high school class.
Read this entire file before producing any output.

---

## Classroom Context (always apply)

**Environment**
- 32 Dell Precision 3260s, 32 GB RAM each, Windows 11 host OS
- VirtualBox installed; students have previously set up:
  - Ubuntu Desktop (general-purpose workstation)
  - Kali Linux (pentesting attacker)
  - Ubuntu Server (Minecraft server)
  - Metasploitable 2 (vulnerable target -- credentials: msfadmin / msfadmin)
- VMs communicate via host-only or NAT networks within VirtualBox
- Internet access may be restricted by school network; do not assume it unless noted

**Students**
- Grades 9-12, mixed experience in a single section (~20 students per section)
- ~15 beginners: many have only used Chromebooks; Windows and Linux are genuinely foreign
- ~5 advanced: somewhat comfortable with terminals, have figured things out independently before; some have Windows/gaming PC experience; a few have light Linux exposure
- Dual-credit course: rigor should be defensible at a college level
- Reading stamina and attention vary widely -- concise, chunked writing is essential

**Instructional Philosophy**
- Self-directed: labs should run without the teacher at every machine
- Semi-guided throughout: never pure hand-holding, never completely open-ended
- Reflection over regurgitation: what did students notice and understand?

---

## Inputs

Eric will describe a lab in one or more of these ways:
- Plain English ("I want them to scan Metasploitable2 with nmap")
- Rough notes or an outline
- A tool/technique reference ("build a lab around Metasploit's exploit/multi/handler")

If the description is ambiguous about scope or complexity, state your assumption clearly in the Teacher Note before the lab content.

---

## Dual-Track Design

Every lab has two parallel pathways -- not two separate labs, but two versions of the same lab that share Overview, Objectives, Background, and Setup, then diverge at Lab Steps.

### Beginner Track (~15 students)
- Semi-guided: provide exact commands with flags explained; require students to read and interpret output themselves -- do not pre-interpret for them
- Include "What you should see" callouts (describe expected output; do not explain meaning)
- Define all vocabulary inline; include a Key Terms box
- More frequent checkpoint prompts to prevent students from getting lost
- Troubleshooting tips for the most common failure points

### Advanced Track (~5 students)
- Semi-guided at a higher level: state the goal and key milestones; provide tool or
  module names without full syntax -- students determine flags and options
- No "What to expect" spoilers -- students discover output on their own
- Fewer checkpoints; more open-ended observation and analysis prompts
- One optional challenge extension beyond the core lab

Both tracks share Background and Setup. Label sections clearly:
"Lab Steps -- Beginner Track" and "Lab Steps -- Advanced Track"

---

## Output Format

Produce four things in this order:

---

### 1. Teacher Note (inline, not a file)

5-8 bullet points covering:
- Assumptions made about lab scope or VM configuration
- Recommended VM network adapter setting (Host-Only / NAT / Internal Network)
- Any required pre-configuration Eric needs to do before students start
- Estimated completion time: Beginner Track / Advanced Track (honest -- err longer)
- Common failure points and quick in-class diagnosis
- Suggested pacing or grouping notes if relevant

---

### 2. Student Lab Document

Output as both:

**A. Markdown version**
Wrapped in a fenced code block so Eric can paste into Google Docs or a shared document.

**B. HTML artifact**
A polished, self-contained HTML file students open in a browser.
Design:
- Terminal/hacker aesthetic: dark background (#0d1117), monospace font for commands,
  green or amber accent for headings, track labels, highlights
- Non-monospace body text for prose
- Commands in styled code blocks with click-to-copy if feasible
- Checkpoint callout boxes visually distinct (different border/background)
- Beginner and Advanced track sections visually differentiated (different accent or badge)
- Fully self-contained -- no external CDN (Google Fonts via @import in style is OK)
- @media print stylesheet included

**Lab document structure:**

  # [Lab Title]
  Course: Cybersecurity | Duration: [Beginner est.] / [Advanced est.] | Difficulty: [level]

  ## Overview
  2-3 sentences: what is this lab and why does it matter in the real world?

  ## Learning Objectives
  3-5 bullet points with action verbs (Identify, Demonstrate, Analyze, Exploit...).
  Shared by both tracks.

  ## Background
  3-5 short paragraphs. Define vocabulary inline. Written for a student who has only
  ever used a Chromebook -- no assumed prior knowledge.

  ### Key Terms
  4-8 terms with plain-English definitions. No jargon in the definitions.

  ## Lab Environment Setup  [shared by both tracks]
  - Which VMs to start and in what order
  - Network adapter setting
  - Credentials if needed
  - Connectivity verification step (ping or equivalent)

  ## Lab Steps -- Beginner Track
  Numbered steps. Each step:
    - Action (command with flags shown and briefly explained)
    - What you should see (a hint -- not an interpretation)
    - Checkpoint: [prompt asking student to record what they observed]
  Troubleshooting tip after any step likely to fail.

  ## Lab Steps -- Advanced Track
  Numbered milestones. Each:
    - Goal statement (what to accomplish, not how)
    - Key tool or module name (without full syntax)
    - Checkpoint: [open-ended observation or analysis prompt]
  Optional Challenge at the end.

  ## Wrap-Up  [shared]
  Short paragraph connecting the lab to a real-world scenario: penetration testing,
  threat modeling, defensive posture, or incident response.

---

### 3. Teacher Guide

A short, scannable Markdown section (not student-facing). Keep it lean -- Eric solves problems in real time; this just flags the non-obvious ones before they become 20 raised hands.

**Before class (checklist)**
Bullet list of setup steps easy to forget: VM snapshots, network adapter settings, anything that needs staging. Only include steps not obvious from the lab itself.

**Student gotcha's**
5-8 bullets max. Each is a specific thing students commonly miss, misread, or silently get wrong -- with a one-line fix or tell-tale sign. Format:

  - GOTCHA: [what happens] -- FIX: [what to look for or tell them]

Focus on: steps that fail quietly (no error, wrong result), CLI syntax traps, VM network issues, and output that looks wrong but is actually correct (or vice versa).

**One thing to watch on the Advanced Track**
A single sentence flagging the most likely sticking point for the 5 advanced students.

---

### 4. Google Form Question List

A numbered list of 10-14 questions. For each question:
- Question text (copy-paste ready for Google Forms)
- Question type: Short answer / Paragraph / Multiple choice / Checkbox / Linear scale
- Answer choices if multiple choice; scale endpoints if linear scale

Guidelines:
- Questions work for both tracks (accommodate different levels of detail in answers)
- Mix: factual recall, observation-based ("What did you notice when..."), analytical ("Why do you think..."), and at least one "I'm still confused about..." open-ender
- At least one question asks students to describe or paste an unexpected result
- At least one question connects the lab to a real-world attack or defense scenario
- No yes/no questions -- use "Describe..." / "Explain..." / "What happened when..." stems
- If a technical term appears in a question, include a brief parenthetical definition
- Final question: confidence self-rating -- "How confident do you feel using [core skill] after this lab?" Linear scale 1-5, labeled "Not at all confident" to "Very confident"

---

## Quality Checks

Verify before outputting:
- All commands are syntactically correct for the target OS (Kali, Ubuntu, or Windows)
- VM names match Eric's setup exactly (Metasploitable 2, not Metasploitable 3)
- Credentials are correct (msfadmin/msfadmin for Metasploitable 2)
- No step assumes internet access unless explicitly noted
- Learning objectives are measurable and map to actual lab activities
- Both tracks achieve the same core objectives via different paths
- Reflection questions align to lab steps -- no orphan questions
- Advanced Track is genuinely open-ended, not just Beginner with less text

---

## Example Trigger Phrases

- "Build a lab where students use nmap to discover open ports on Metasploitable2"
- "I want to teach password cracking with John the Ripper"
- "Make a Metasploit exploitation lab -- they've already done recon"
- "Design something around Wireshark and packet capture"
- "Lab idea: students investigate a fake phishing email artifact using Linux tools"
- "Create a beginner lab for students who have never opened a terminal"
- "Build a CTF-style challenge around privilege escalation"